package miu.edu.service;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.MessageToMotionPicturesDTO;
import miu.edu.model.Comment;
import miu.edu.model.MotionPictureType;
import miu.edu.repository.CommentRepository;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final RabbitTemplate rabbitTemplate;

    @Override
    public List<Comment> getAllComments() {
        List<Comment> list = new ArrayList<>();
        commentRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment addComment(Comment comment) {
        try {
            Comment savedComment = commentRepository.save(comment);

            // send a message
            String routingKey = savedComment.getMotionPictureType().toString();
            Long motionPictureId = savedComment.getMotionPictureId();
            sendMessageToMotionPicture(routingKey, motionPictureId);

            return savedComment;
        } catch (RuntimeException e) {
            // TODO save error log
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void removeComment(Long id) {

        String routingKey = commentRepository.findById(id)
                .map(c -> c.getMotionPictureType().toString())
                .orElse(null);

        Long motionPictureId = commentRepository.findById(id)
                .map(Comment::getMotionPictureId)
                .orElse(null);

        commentRepository.deleteById(id);

        // send a message
        if (routingKey != null) {
            sendMessageToMotionPicture(routingKey, motionPictureId);
        }
    }

    @Override
    public Comment updateComment(Long id, Comment comment) {
        comment.setId(id);

        String routingKeyBefore = commentRepository.findById(id)
                .map(c -> c.getMotionPictureType().toString())
                .orElse(null);

        Long motionPictureIdBefore = commentRepository.findById(id)
                .map(Comment::getMotionPictureId)
                .orElse(null);

        Comment savedComment = commentRepository.save(comment);

        // send a message
        String routingKey = savedComment.getMotionPictureType().toString();
        Long motionPictureId = savedComment.getMotionPictureId();

        if ((routingKeyBefore != null && !routingKeyBefore.equals(routingKey))
                || (motionPictureIdBefore != null && !motionPictureIdBefore.equals(motionPictureId))) {
            sendMessageToMotionPicture(routingKeyBefore, motionPictureIdBefore);
        }

        sendMessageToMotionPicture(routingKey, motionPictureId);

        return savedComment;
    }

    @Override
    public List<Comment> getCommentsByMoviesId(Long motionPicId) {
        return commentRepository.findAllByMotionPictureTypeEqualsAndMotionPictureIdEquals(MotionPictureType.MOVIE,
                motionPicId);
    }

    @Override
    public List<Comment> getCommentsByTvshowId(Long motionPicId) {
        return commentRepository.findAllByMotionPictureTypeEqualsAndMotionPictureIdEquals(MotionPictureType.TVSHOW,
                motionPicId);
    }

    @Override
    public void sendMessageToMotionPicture(String routingKey, Long motionPictureId) {
        try {
            Integer numberOfComments = commentRepository.getCommentCountByMotionPictureId(motionPictureId);
            rabbitTemplate.setExchange("motionPictureDirectExchange");

            MessageToMotionPicturesDTO messageDTO = new MessageToMotionPicturesDTO(numberOfComments, motionPictureId);
            rabbitTemplate.convertAndSend(routingKey, messageDTO);

            // StringBuilder messageBuilder = new StringBuilder();
            // messageBuilder.append("numberOfComments:");
            // messageBuilder.append(numberOfComments.toString());
            // messageBuilder.append(",");

            // messageBuilder.append("motionPictureId:");
            // messageBuilder.append(motionPictureId.toString());

            // rabbitTemplate.convertAndSend(routingKey, messageBuilder.toString());
        } catch (AmqpException amqpException) {
            // TODO save error log
            System.out.println(amqpException.getMessage());
        }
    }
}

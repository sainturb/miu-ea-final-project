package miu.edu.service;

import miu.edu.model.Comment;
import miu.edu.model.MotionPictureType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    List<Comment> getAllComments();
    Comment getCommentById(Long id);
    Comment addComment(Comment comment);
    void removeComment(Long id);
    Comment updateComment(Long id, Comment comment);

    List<Comment> getCommentsByMoviesId(Long motionPicId);

    List<Comment> getCommentsByTvshowId(Long motionPicId);

    /**
     * Sends count of comments to movie or tv show service by motion picture id(movie or tv show).
     * @param savedComment
     */
    void sendMessageToMotionPicture(String routingKey, Long motionPictureId);
}

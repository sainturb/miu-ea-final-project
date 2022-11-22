package miu.edu.repository;

import miu.edu.model.Comment;
import miu.edu.model.MotionPictureType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    @Query("SELECT count(c) FROM Comment c WHERE c.motionPictureId = :motionPictureId group by c.motionPictureId")
    Integer getCommentCountByMotionPictureId(Long motionPictureId);

    List<Comment> findAllByMotionPictureTypeEqualsAndMotionPictureIdEquals(MotionPictureType motionPictureType, Long motionPicId);
}

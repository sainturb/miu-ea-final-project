package miu.edu.repo;

import miu.edu.model.MotionPictureType;
import miu.edu.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Long> {
     Rating findRatingById(Long id);
     List<Rating> findAllByMotionPictureIdAndMotionPictureType(Long id, MotionPictureType type);
}

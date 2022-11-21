package miu.edu.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import miu.edu.model.MotionPicture;

@Repository
public interface MotionPictureRepo extends CrudRepository<MotionPicture, Long> {
    List<MotionPicture> findAllByReleasedYearEquals(int releasedYear);

    List<MotionPicture> findAllByRatingGreaterThanEqual(double minRating);

    List<MotionPicture> findAllByRatingLessThanEqual(double maxRating);

    List<MotionPicture> findAllByRatingBetween(double minRating, double maxRating);

    List<MotionPicture> findAllByRatingEquals(double rating);

    List<MotionPicture> findAllByGenres_NameEquals(String genreName);

    List<MotionPicture> findAllByGenresId(Long genresId);

    List<MotionPicture> findAllByDirectorIdEquals(Long directorid);

    List<MotionPicture> findAllByDurationGreaterThanEqual(double minDuration);

    List<MotionPicture> findAllByDurationLessThanEqual(double maxDuration);

    List<MotionPicture> findAllByDurationBetween(double minDuration, double maxDuration);

    List<MotionPicture> findAllByDurationEquals(double duration);

    List<MotionPicture> findAllByCharacters_ActorIdEquals(Long actorId);
}

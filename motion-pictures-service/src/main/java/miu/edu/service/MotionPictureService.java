package miu.edu.service;

import java.util.List;

import miu.edu.model.MotionPicture;

public interface MotionPictureService {
    List<MotionPicture> getAllMotionPictures();

    MotionPicture getMotionPictureById(long id);

    MotionPicture addMotionPicture(MotionPicture motionPicture);

    boolean removeMotionPicture(long id);

    MotionPicture updateMotionPicture(long id, MotionPicture motionPicture);

    // Filters
    List<MotionPicture> findAllByReleasedYearEquals(int releasedYear);

    List<MotionPicture> findAllByRatingGreaterThanOrEquals(double minRating);

    List<MotionPicture> findAllByRatingLessThanOrEquals(double maxRating);

    List<MotionPicture> findAllByRatingBetween(double minRating, double maxRating);

    List<MotionPicture> findAllByRatingEquals(double rating);

    List<MotionPicture> findAllByGenresId(Long genreId);

    List<MotionPicture> findAllByGenres_NameEquals(String genreName);

    List<MotionPicture> findAllByDirectorIdEquals(Long directorid);

    List<MotionPicture> findAllByDurationGreaterThanOrEquals(double minDuration);

    List<MotionPicture> findAllByDurationLessThanOrEquals(double maxDuration);

    List<MotionPicture> findAllByDurationBetween(double minDuration, double maxDuration);

    List<MotionPicture> findAllByDurationEquals(double duration);

    List<MotionPicture> findAllByCharacters_ActorIdEquals(Long actorId);
}

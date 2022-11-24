package miu.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import miu.edu.dto.MotionPictureDTO;

@Service
public interface MotionPictureService {
    List<MotionPictureDTO> getAllMotionPictures();

    MotionPictureDTO getMotionPictureById(Long id);

    MotionPictureDTO addMotionPicture(MotionPictureDTO motionPictureDTO);

    boolean removeMotionPicture(Long id);

    MotionPictureDTO updateMotionPicture(Long id, MotionPictureDTO motionPictureDTO);

    // Filters
    List<MotionPictureDTO> findAllByReleasedYearEquals(int releasedYear);

    List<MotionPictureDTO> findAllByRatingGreaterThanOrEquals(double minRating);

    List<MotionPictureDTO> findAllByRatingLessThanOrEquals(double maxRating);

    List<MotionPictureDTO> findAllByRatingBetween(double minRating, double maxRating);

    List<MotionPictureDTO> findAllByRatingEquals(double rating);

    List<MotionPictureDTO> findAllByGenresId(Long genreId);

    List<MotionPictureDTO> findAllByGenres_NameEquals(String genreName);

    List<MotionPictureDTO> findAllByDirectorIdEquals(Long directorid);

    List<MotionPictureDTO> findAllByDurationGreaterThanOrEquals(double minDuration);

    List<MotionPictureDTO> findAllByDurationLessThanOrEquals(double maxDuration);

    List<MotionPictureDTO> findAllByDurationBetween(double minDuration, double maxDuration);

    List<MotionPictureDTO> findAllByDurationEquals(double duration);

    List<MotionPictureDTO> findAllByCharacters_ActorIdEquals(Long actorId);

}

package miu.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import miu.edu.model.MotionPicture;
import miu.edu.repository.MotionPictureRepo;
import miu.edu.service.MotionPictureService;

@Service
@RequiredArgsConstructor
public class MotionPictureServiceImpl implements MotionPictureService {

    private final MotionPictureRepo motionPictureRepo;

    @Override
    public List<MotionPicture> getAllMotionPictures() {
        List<MotionPicture> motionPictures = new ArrayList<>();
        motionPictureRepo.findAll().forEach(motionPictures::add);
        return motionPictures;
    }

    @Override
    public MotionPicture getMotionPictureById(long id) {
        return motionPictureRepo.findById(id).orElse(null);
    }

    @Override
    public MotionPicture addMotionPicture(MotionPicture motionPicture) {
        MotionPicture savedMotionPicture = motionPictureRepo.save(motionPicture);
        return savedMotionPicture;
    }

    @Override
    public boolean removeMotionPicture(long id) {
        try {
            motionPictureRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public MotionPicture updateMotionPicture(long id, MotionPicture motionPicture) {
        motionPicture.setId(id);
        MotionPicture savedMotionPicture = motionPictureRepo.save(motionPicture);
        return savedMotionPicture;
    }

    // Filters
    @Override
    public List<MotionPicture> findAllByReleasedYearEquals(int releasedYear) {
        return motionPictureRepo.findAllByReleasedYearEquals(releasedYear);
    }

    @Override
    public List<MotionPicture> findAllByRatingGreaterThanOrEquals(double minRating) {
        return motionPictureRepo.findAllByRatingGreaterThanEqual(minRating);
    }

    @Override
    public List<MotionPicture> findAllByRatingLessThanOrEquals(double maxRating) {
        return motionPictureRepo.findAllByRatingLessThanEqual(maxRating);
    }

    @Override
    public List<MotionPicture> findAllByRatingBetween(double minRating, double maxRating) {
        return motionPictureRepo.findAllByRatingBetween(minRating, maxRating);
    }

    @Override
    public List<MotionPicture> findAllByRatingEquals(double rating) {
        return motionPictureRepo.findAllByRatingEquals(rating);
    }

    @Override
    public List<MotionPicture> findAllByGenresId(Long genreId) {
        return motionPictureRepo.findAllByGenresId(genreId);
    }

    @Override
    public List<MotionPicture> findAllByGenres_NameEquals(String genreName) {
        return motionPictureRepo.findAllByGenres_NameEquals(genreName);
    }

    @Override
    public List<MotionPicture> findAllByDirectorIdEquals(Long directorid) {
        return motionPictureRepo.findAllByDirectorIdEquals(directorid);
    }

    @Override
    public List<MotionPicture> findAllByDurationGreaterThanOrEquals(double minDuration) {
        return motionPictureRepo.findAllByDurationGreaterThanEqual(minDuration);
    }

    @Override
    public List<MotionPicture> findAllByDurationLessThanOrEquals(double maxDuration) {
        return motionPictureRepo.findAllByDurationLessThanEqual(maxDuration);
    }

    @Override
    public List<MotionPicture> findAllByDurationBetween(double minDuration, double maxDuration) {
        return motionPictureRepo.findAllByDurationBetween(minDuration, maxDuration);
    }

    @Override
    public List<MotionPicture> findAllByDurationEquals(double duration) {
        return motionPictureRepo.findAllByDurationEquals(duration);
    }

    @Override
    public List<MotionPicture> findAllByCharacters_ActorIdEquals(Long actorId) {
        return motionPictureRepo.findAllByCharacters_ActorIdEquals(actorId);
    }

}

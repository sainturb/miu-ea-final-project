package miu.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.MotionPictureDTO;
import miu.edu.model.MotionPicture;
import miu.edu.repository.MotionPictureRepo;
import miu.edu.service.MotionPictureService;

@Service
@RequiredArgsConstructor
public class MotionPictureServiceImpl implements MotionPictureService {

    private final MotionPictureRepo motionPictureRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<MotionPictureDTO> getAllMotionPictures() {
        List<MotionPicture> motionPictures = new ArrayList<>();
        motionPictureRepo.findAll().forEach(motionPictures::add);

        List<MotionPictureDTO> motionPicturesDTO = new ArrayList<>();
        motionPictures.forEach(m -> motionPicturesDTO.add(modelMapper.map(m, MotionPictureDTO.class)));

        return motionPicturesDTO;
    }

    @Override
    public MotionPictureDTO getMotionPictureById(Long id) {
        MotionPicture motionPicture = motionPictureRepo.findById(id).orElse(null);
        return modelMapper.map(motionPicture, MotionPictureDTO.class);
    }

    @Override
    public MotionPictureDTO addMotionPicture(MotionPictureDTO motionPictureDTO) {
        MotionPicture motionPicture = modelMapper.map(motionPictureDTO, MotionPicture.class);
        try {
            MotionPicture savedMotionPicture = motionPictureRepo.save(motionPicture);
            MotionPictureDTO savedmotionPictureDTO = modelMapper.map(savedMotionPicture, MotionPictureDTO.class);
            return savedmotionPictureDTO;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean removeMotionPicture(Long id) {
        try {
            motionPictureRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public MotionPictureDTO updateMotionPicture(Long id, MotionPictureDTO motionPictureDTO) {
        MotionPicture motionPicture = modelMapper.map(motionPictureDTO, MotionPicture.class);
        motionPicture.setId(id);
        MotionPicture savedMotionPicture = motionPictureRepo.save(motionPicture);
        MotionPictureDTO savedmotionPictureDTO = modelMapper.map(savedMotionPicture, MotionPictureDTO.class);
        return savedmotionPictureDTO;
    }

    private List<MotionPictureDTO> mapToDTO(List<MotionPicture> motionPictures) {
        List<MotionPictureDTO> motionPicturesDTO = new ArrayList<>();
        motionPictures.forEach(m -> motionPicturesDTO.add(modelMapper.map(m, MotionPictureDTO.class)));
        return motionPicturesDTO;
    }

    // Filters
    @Override
    public List<MotionPictureDTO> findAllByReleasedYearEquals(int releasedYear) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByReleasedYearEquals(releasedYear);
        return mapToDTO(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByRatingGreaterThanOrEquals(double minRating) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByRatingGreaterThanEqual(minRating);
        return mapToDTO(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByRatingLessThanOrEquals(double maxRating) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByRatingLessThanEqual(maxRating);
        return mapToDTO(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByRatingBetween(double minRating, double maxRating) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByRatingBetween(minRating, maxRating);
        return mapToDTO(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByRatingEquals(double rating) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByRatingEquals(rating);
        return mapToDTO(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByGenresId(Long genreId) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByGenresId(genreId);
        return mapToDTO(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByGenres_NameEquals(String genreName) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByGenres_NameEquals(genreName);
        return mapToDTO(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByDirectorIdEquals(Long directorid) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByDirectorIdEquals(directorid);
        return mapToDTO(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByDurationGreaterThanOrEquals(double minDuration) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByDurationGreaterThanEqual(minDuration);
        return mapToDTO(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByDurationLessThanOrEquals(double maxDuration) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByDurationLessThanEqual(maxDuration);
        return mapToDTO(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByDurationBetween(double minDuration, double maxDuration) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByDurationBetween(minDuration, maxDuration);
        return mapToDTO(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByDurationEquals(double duration) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByDurationEquals(duration);
        return mapToDTO(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByCharacters_ActorIdEquals(Long actorId) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByCharacters_ActorIdEquals(actorId);
        return mapToDTO(motionPictures);
    }

}

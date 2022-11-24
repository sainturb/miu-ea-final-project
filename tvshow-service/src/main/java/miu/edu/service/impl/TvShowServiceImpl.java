package miu.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.MessageToMotionPicturesDTO;
import miu.edu.dto.MotionPictureDTO;
import miu.edu.dto.RatingDTO;
import miu.edu.dto.TvShowDTO;
import miu.edu.model.MotionPicture;
import miu.edu.model.TvShow;
import miu.edu.repository.MotionPictureRepo;
import miu.edu.service.TvShowService;

@Service
@RequiredArgsConstructor
@Primary
public class TvShowServiceImpl implements TvShowService {

    private final MotionPictureRepo motionPictureRepo;
    private final ModelMapper modelMapper;

    private List<MotionPictureDTO> mapToDTOList(List<MotionPicture> motionPictures) {
        List<MotionPictureDTO> motionPicturesDTO = new ArrayList<>();
        motionPictures.forEach(m -> motionPicturesDTO.add(modelMapper.map(m,
                TvShowDTO.class)));
        return motionPicturesDTO;
    }

    @Override
    public List<MotionPictureDTO> getAllMotionPictures() {
        List<MotionPicture> motionPictures = new ArrayList<>();
        motionPictureRepo.findAll().forEach(motionPictures::add);

        return mapToDTOList(motionPictures);
    }

    @Override
    public MotionPictureDTO getMotionPictureById(Long id) {
        MotionPicture motionPicture = motionPictureRepo.findById(id).orElse(null);
        return modelMapper.map(motionPicture, TvShowDTO.class);
    }

    @Override
    public MotionPictureDTO addMotionPicture(MotionPictureDTO motionPictureDTO) {

        try {
            MotionPicture motionPicture = modelMapper.map(motionPictureDTO,
                    TvShow.class);
            MotionPicture savedTvShow = motionPictureRepo.save(motionPicture);

            MotionPictureDTO savedMotionPicture = modelMapper.map(savedTvShow,
                    TvShowDTO.class);
            return savedMotionPicture;
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
        MotionPicture motionPicture = modelMapper.map(motionPictureDTO,
                TvShow.class);
        motionPicture.setId(id);
        MotionPicture savedMotionPicture = motionPictureRepo.save(motionPicture);
        MotionPictureDTO savedmotionPictureDTO = modelMapper.map(savedMotionPicture,
                TvShowDTO.class);
        return savedmotionPictureDTO;
    }

    // Filters
    @Override
    public List<MotionPictureDTO> findAllByReleasedYearEquals(int releasedYear) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByReleasedYearEquals(releasedYear);
        return mapToDTOList(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByRatingGreaterThanOrEquals(double minRating) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByRatingGreaterThanEqual(minRating);
        return mapToDTOList(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByRatingLessThanOrEquals(double maxRating) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByRatingLessThanEqual(maxRating);
        return mapToDTOList(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByRatingBetween(double minRating, double maxRating) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByRatingBetween(minRating, maxRating);
        return mapToDTOList(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByRatingEquals(double rating) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByRatingEquals(rating);
        return mapToDTOList(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByGenresId(Long genreId) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByGenresId(genreId);
        return mapToDTOList(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByGenres_NameEquals(String genreName) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByGenres_NameEquals(genreName);
        return mapToDTOList(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByDirectorIdEquals(Long directorid) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByDirectorIdEquals(directorid);
        return mapToDTOList(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByDurationGreaterThanOrEquals(double minDuration) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByDurationGreaterThanEqual(minDuration);
        return mapToDTOList(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByDurationLessThanOrEquals(double maxDuration) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByDurationLessThanEqual(maxDuration);
        return mapToDTOList(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByDurationBetween(double minDuration,
            double maxDuration) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByDurationBetween(minDuration, maxDuration);
        return mapToDTOList(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByDurationEquals(double duration) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByDurationEquals(duration);
        return mapToDTOList(motionPictures);
    }

    @Override
    public List<MotionPictureDTO> findAllByCharacters_ActorIdEquals(Long actorId) {
        List<MotionPicture> motionPictures = motionPictureRepo.findAllByCharacters_ActorIdEquals(actorId);
        return mapToDTOList(motionPictures);
    }

    @Override
    @RabbitListener(queues = { "tvShowQueue" })
    @Transactional
    public void listenForCommentService(MessageToMotionPicturesDTO payload) {
        if (payload == null)
            return;

        if (payload.getMotionPictureId() != null) {
            MotionPicture foundMovie = motionPictureRepo.findById(payload.getMotionPictureId()).orElse(null);
            if (foundMovie != null) {
                foundMovie.setNumberOfComments(payload.getNumberOfComments());
            }
        }
    }

    @Override
    @KafkaListener(topics = "TVSHOW", groupId = "group-1", containerFactory = "kafkaRatingListenerStringContainerFactory")
    @Transactional
    public void listenForRatingService(RatingDTO message) {
        if (message.getMotionPictureId() == null) {
            return;
        }
        MotionPicture foundedTvShow = motionPictureRepo.findById(message.getMotionPictureId()).orElse(null);
        if (foundedTvShow == null) {
            return;
        }
        foundedTvShow.setRating(message.getAvgRating());
    }

}

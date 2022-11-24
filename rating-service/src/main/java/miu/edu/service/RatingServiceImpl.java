package miu.edu.service;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.RatingDTO;
import miu.edu.model.MotionPictureType;
import miu.edu.model.Rating;
import miu.edu.repo.RatingRepo;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepo ratingRepo;

    private final ModelMapper mapper;

    private final KafkaTemplate<String, RatingDTO> motionPicturesKafkaTemplate;

    @Override
    public List<Rating> findAll() {
        List<Rating> list = new ArrayList<>();
        ratingRepo.findAll().forEach(rating -> list.add(rating));
        return list;
    }

    @Override
    public Rating saveRating(Rating rating) {
        ratingProduce(rating);
        return ratingRepo.save(rating);
    }

    public void ratingProduce(Rating rating) {
        try {
            String topic = rating.getMotionPictureType().toString(); // tvshow, movie
            List<Rating> all = ratingRepo.findAllByMotionPictureIdAndMotionPictureType(rating.getMotionPictureId(), rating.getMotionPictureType());
            Double averageRate = all.stream().map(Rating::getRating).reduce((item1, item2) -> (item1 + item2) / 2).orElse(5.0);
            RatingDTO averaged = new RatingDTO(rating.getMotionPictureId(), all.size() + 1, averageRate);
            ProducerRecord<String, RatingDTO> record = new ProducerRecord<>(topic, averaged);
            motionPicturesKafkaTemplate.send(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Rating updateRating(Long id, Rating rating) {
        rating.setId(id);
        Rating saved = ratingRepo.save(rating);
        ratingProduce(findRatingById(id));
        return saved;
    }

    @Override
    public void deleteRating(Long id) {
        ratingRepo.deleteById(id);
        ratingProduce(findRatingById(id));
    }

    @Override
    public Rating findRatingById(Long id) {
        return ratingRepo.findRatingById(id);
    }

}

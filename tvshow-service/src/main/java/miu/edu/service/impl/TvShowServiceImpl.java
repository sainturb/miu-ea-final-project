package miu.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.MessageToMotionPicturesDTO;
import miu.edu.model.TvShow;
import miu.edu.repository.TvShowRepo;
import miu.edu.service.TvShowService;

@Service
@RequiredArgsConstructor
public class TvShowServiceImpl implements TvShowService {

    private final TvShowRepo tvShowRepo;

    @Override
    public List<TvShow> getAllTvShows() {
        List<TvShow> TvShows = new ArrayList<>();
        tvShowRepo.findAll().forEach(TvShows::add);
        return TvShows;
    }

    @Override
    public TvShow getTvShowById(long id) {
        return tvShowRepo.findById(id).orElse(null);
    }

    @Override
    public TvShow addTvShow(TvShow TvShow) {
        TvShow savedTvShow = tvShowRepo.save(TvShow);
        return savedTvShow;
    }

    @Override
    public boolean removeTvShow(long id) {
        try {
            tvShowRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public TvShow updateTvShow(long id, TvShow TvShow) {
        TvShow.setId(id);
        TvShow savedTvShow = tvShowRepo.save(TvShow);
        return savedTvShow;
    }

    @Override
    @RabbitListener(queues = { "tvShowQueue" })
    @Transactional
    public void listenForCommentService(MessageToMotionPicturesDTO payload) {
        if (payload == null)
            return;

        if (payload.getMotionPictureId() != null) {
            TvShow foundMovie = tvShowRepo.findById(payload.getMotionPictureId()).orElse(null);
            if (foundMovie != null) {
                foundMovie.setNumberOfComments(payload.getNumberOfComments());
            }
        }
    }

    @Override
    @KafkaListener(topics = "tvshow", containerFactory = "kafkaRatingListenerStringContainerFactory", groupId = "tvshow")
    @Transactional
    public void listenForRatingService(ConsumerRecord<String, String> cr, @Payload String message) {
        // TODO persist average rating
        System.out.println(message);
    }

}

package miu.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.MessageToMotionPicturesDTO;
import miu.edu.dto.RatingDTO;
import miu.edu.model.Movie;
import miu.edu.repository.MovieRepo;
import miu.edu.service.MovieService;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepo movieRepo;

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        movieRepo.findAll().forEach(movies::add);
        return movies;
    }

    @Override
    public Movie getMovieById(long id) {
        return movieRepo.findById(id).orElse(null);
    }

    @Override
    public Movie addMovie(Movie Movie) {
        Movie savedMovie = movieRepo.save(Movie);
        return savedMovie;
    }

    @Override
    public boolean removeMovie(long id) {
        try {
            movieRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Movie updateMovie(long id, Movie Movie) {
        Movie.setId(id);
        Movie savedMovie = movieRepo.save(Movie);
        return savedMovie;
    }

    @Override
    @RabbitListener(queues = { "movieQueue" })
    @Transactional
    public void listenForCommentService(MessageToMotionPicturesDTO payload) {
        if (payload == null)
            return;

        if (payload.getMotionPictureId() != null) {
            Movie foundMovie = movieRepo.findById(payload.getMotionPictureId()).orElse(null);
            foundMovie.setNumberOfComments(payload.getNumberOfComments());
            // movieRepo.save(foundMovie);
        }
    }

    @Override
    @KafkaListener(topics = "MOVIE", groupId = "group-1", containerFactory = "kafkaRatingListenerStringContainerFactory")
    @Transactional
    public void listenForRatingService(RatingDTO message) {
        if (message.getMotionPictureId() == null) {
            return;
        }
        Movie foundedMovie = movieRepo.findById(message.getMotionPictureId()).orElse(null);
        if (foundedMovie == null) {
            return;
        }
        foundedMovie.setAverageRating(message.getAvgRating());
    }

}

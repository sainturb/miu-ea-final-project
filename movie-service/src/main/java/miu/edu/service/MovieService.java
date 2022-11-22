package miu.edu.service;

import java.util.List;

import miu.edu.dto.MessageToMotionPicturesDTO;
import miu.edu.model.Movie;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(long id);

    Movie addMovie(Movie Movie);

    boolean removeMovie(long id);

    Movie updateMovie(long id, Movie Movie);

    void listenForCommentService(MessageToMotionPicturesDTO payload);
}

package miu.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
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

}

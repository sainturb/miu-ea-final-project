package miu.edu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miu.edu.service.MotionPictureService;

@RestController
// @RequiredArgsConstructor
@RequestMapping("api/v1/movies")
public class MovieController extends MotionPictureContoller {

    public MovieController(MotionPictureService motionPictureService) {
        super(motionPictureService);
    }

    // private final MovieService movieService;

    // @GetMapping
    // public List<Movie> getAllMovies() {
    // return movieService.getAllMovies();
    // }

    // @GetMapping("/{id}")
    // public Movie getMovieById(@PathVariable long id) {
    // return movieService.getMovieById(id);
    // }

    // @PostMapping
    // public Movie getAllMovies(@RequestBody Movie Movie) {
    // return movieService.addMovie(Movie);
    // }

    // @DeleteMapping("/{id}")
    // public Boolean deleteMovieById(@PathVariable long id) {
    // return movieService.removeMovie(id);
    // }

    // @PutMapping("/{id}")
    // public Movie updateMovie(@PathVariable long id, @RequestBody Movie Movie) {
    // return movieService.updateMovie(id, Movie);
    // }
}

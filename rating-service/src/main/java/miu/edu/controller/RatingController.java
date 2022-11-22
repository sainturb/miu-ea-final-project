package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.DTO.RatingDTO;
import miu.edu.model.Rating;
import miu.edu.service.RatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ratings")
public class RatingController {
    private final RatingService ratingService;


    @GetMapping
    public List<Rating> findAll(){
        return ratingService.findAll();
    }


    @PostMapping
    public Rating saveRating(@RequestBody Rating rating){
        return ratingService.saveRating(rating);
    }
    @PutMapping("/{id}")
    public Rating updateRating(@PathVariable int id, @RequestBody Rating rating){
        return ratingService.updateRating(id, rating);
    }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable int id){
            ratingService.deleteRating(id);
    }

    @GetMapping("/{id}")
    public Rating findRatingById(@PathVariable int id){
        return ratingService.findRatingById(id);
    }

    @GetMapping("/movies/{id}")
    public List<Rating> findRatingByMoviesId(@PathVariable int id){
        return ratingService.findRatingByMovieId(id);
    }

    @GetMapping("/tvshows/{id}")
    public List<Rating> findRatingByTvshowId(@PathVariable int id){
        return ratingService.findRatingByTvshowId(id);
    }


}

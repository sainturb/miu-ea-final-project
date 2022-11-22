package miu.edu.controller;

import lombok.RequiredArgsConstructor;
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
    public Rating updateRating(@PathVariable Long id, @RequestBody Rating rating){
        return ratingService.updateRating(id, rating);
    }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable Long id){
            ratingService.deleteRating(id);
    }

    @GetMapping("/{id}")
    public Rating findRatingById(@PathVariable Long id){
        return ratingService.findRatingById(id);
    }
}

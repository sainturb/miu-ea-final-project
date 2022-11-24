package miu.edu.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import miu.edu.model.Rating;
import miu.edu.service.RatingService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ratings")
public class RatingController {
    private final RatingService ratingService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Rating> findAll() {
        return ratingService.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public Rating saveRating(@RequestBody Rating rating) {
        return ratingService.saveRating(rating);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Rating updateRating(@PathVariable Long id, @RequestBody Rating rating) {
        return ratingService.updateRating(id, rating);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Rating findRatingById(@PathVariable Long id) {
        return ratingService.findRatingById(id);
    }
}

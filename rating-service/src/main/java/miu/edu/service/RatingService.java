package miu.edu.service;

import miu.edu.dto.RatingDTO;
import miu.edu.model.Rating;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RatingService {
     List<Rating> findAll();
     Rating saveRating(Rating rating);
     Rating updateRating(Long id, Rating rating);
     void deleteRating(Long id);
     Rating findRatingById(Long id);
}

package miu.edu.service;

import miu.edu.DTO.RatingDTO;
import miu.edu.model.Rating;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RatingService {

     List<Rating> findAll();
     Rating saveRating(Rating rating);
     Rating updateRating(int id, Rating rating);
     void deleteRating(int id);
     Rating findRatingById(int id);

     List<Rating> findRatingByMovieId(int id);
    List<Rating> findRatingByTvshowId(int id);
}

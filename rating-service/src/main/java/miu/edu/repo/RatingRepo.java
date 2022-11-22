package miu.edu.repo;

import miu.edu.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Integer> {
     Rating findRatingById(int id);
     List<Rating> findRatingByMovieId(int id);
     List<Rating> findRatingByTvshowId(int id);
}

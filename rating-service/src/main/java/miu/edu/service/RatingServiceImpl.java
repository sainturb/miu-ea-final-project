package miu.edu.service;

import lombok.RequiredArgsConstructor;
import miu.edu.model.Rating;
import miu.edu.repo.RatingRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService{

    private final RatingRepo ratingRepo;
@Override
   public List<Rating> findAll(){
        List<Rating> list = new ArrayList<>();
        ratingRepo.findAll().forEach(rating -> list.add(rating));
        return list;
    };
//    @Override
//    public Rating saveRating(Rating rating){
//       return ratingRepo.save(rating);
//    };
//    @Override
//   public Rating updateRating(int id, Rating rating){
//       return ratingRepo.save(id, rating);
//   };
//    @Override
//   public void deleteRating(int id){
//       ratingRepo.delete(id);
//   }
//    @Override
//    public Rating findRatingById(int id){
//       return ratingRepo.findRatingById(id);
//    }
//    @Override
//   public List<Rating> findRatingByMovieId(int id){
//       return ratingRepo.findRatingByMovieId(id);
//   }
//    @Override
//   public List<Rating> findRatingByTvshowId(int id){
//       return ratingRepo.findRatingByTvshowId(id);
//   }

}

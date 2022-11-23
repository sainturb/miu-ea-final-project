package miu.edu.service;

import java.util.List;

import miu.edu.dto.MessageToMotionPicturesDTO;
import miu.edu.dto.RatingDTO;
import miu.edu.model.TvShow;

public interface TvShowService {
    List<TvShow> getAllTvShows();

    TvShow getTvShowById(long id);

    TvShow addTvShow(TvShow TvShow);

    boolean removeTvShow(long id);

    TvShow updateTvShow(long id, TvShow TvShow);

    void listenForCommentService(MessageToMotionPicturesDTO payload);

    void listenForRatingService(RatingDTO message);
}

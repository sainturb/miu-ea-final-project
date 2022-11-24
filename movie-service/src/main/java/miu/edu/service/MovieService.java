package miu.edu.service;

import miu.edu.dto.MessageToMotionPicturesDTO;
import miu.edu.dto.RatingDTO;

public interface MovieService extends MotionPictureService {
    void listenForCommentService(MessageToMotionPicturesDTO payload);

    void listenForRatingService(RatingDTO message);
}

package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.model.MotionPictureType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDTO {

    private Long motionPictureId;
    private int totalNumberOfRating;
    private Long avgRating;

}

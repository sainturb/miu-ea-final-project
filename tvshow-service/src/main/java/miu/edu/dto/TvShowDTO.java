package miu.edu.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TvShowDTO extends MotionPictureDTO {
    private int numberOfSeasons;
}

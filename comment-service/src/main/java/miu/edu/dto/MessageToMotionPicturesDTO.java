package miu.edu.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageToMotionPicturesDTO implements Serializable {
    private int numberOfComments;
    private Long motionPictureId;
}

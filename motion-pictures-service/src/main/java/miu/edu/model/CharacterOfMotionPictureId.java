package miu.edu.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class CharacterOfMotionPictureId implements Serializable {
    private Long actorId;
    private Long motionPictureId;

}

package miu.edu.dto;

import lombok.Data;

@Data
public class CharacterOfMotionPictureDTO {

    private Long actorId;
    private Long motionPictureId;
    
    private String name;
    private String additionalInformation;

    // private MotionPictureDTO motionPicture;
    private ActorDTO actor;
}

package miu.edu.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private LocalDateTime dateTime;
    private Long userId;
    private Long motionPictureId;

    @Enumerated(EnumType.STRING)
    private MotionPictureType motionPictureType;
}

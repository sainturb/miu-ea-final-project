package miu.edu.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long motionPictureId;
    private String userId;
    private Double rating;

    @Enumerated(EnumType.STRING)
    private MotionPictureType motionPictureType;
}

package miu.edu.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Long motionPictureId;
    private Long userId;
    private int rating;
    private Long avgRating;

    @Enumerated(EnumType.STRING)
    private MotionPictureType motionPictureType;
}

package miu.edu.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Director extends Person {

    // @OneToMany(mappedBy = "director")
    // @JsonBackReference // (value = "director")
    // private List<MotionPicture> motionPictures;
}

package miu.edu.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Director extends Person {

    @OneToMany(mappedBy = "director")
    @JsonBackReference(value = "director")
    private List<MotionPicture> motionPictures;
}

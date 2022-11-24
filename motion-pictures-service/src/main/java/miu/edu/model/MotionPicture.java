package miu.edu.model;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class MotionPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int releasedYear;
    private double rating;

    @ManyToMany
    @JsonManagedReference
    private List<Genre> genres;

    @ManyToOne
    @JsonManagedReference // (value = "director")
    private Director director;

    @OneToMany(mappedBy = "motionPicture")
    @JsonManagedReference // (value = "motionPicture")
    private List<CharacterOfMotionPicture> characters;

    private double duration;

    private int numberOfComments;
}

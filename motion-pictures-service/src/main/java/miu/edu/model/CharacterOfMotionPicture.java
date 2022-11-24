package miu.edu.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class CharacterOfMotionPicture {
    @EmbeddedId
    private CharacterOfMotionPictureId id;

    private String name;
    private String additionalInformation;

    @JsonBackReference // (value = "motionPicture")
    @ManyToOne
    @MapsId("motionPictureId")
    private MotionPicture motionPicture;

    @JsonManagedReference(value = "actor")
    @ManyToOne
    @MapsId("actorId")
    private Actor actor;
}

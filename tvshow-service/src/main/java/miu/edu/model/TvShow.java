package miu.edu.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("tvshow")
public class TvShow extends MotionPicture {

    private int numberOfSeasons;
}

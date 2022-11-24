package miu.edu.dto;

import java.util.List;

import lombok.Data;
import miu.edu.model.Director;

@Data
public class MotionPictureDTO {

    private String name;
    private int releasedYear;
    private double rating;
    private List<GenreDTO> genres;
    private Director director;
    private double duration;
    private int numberOfComments;
}

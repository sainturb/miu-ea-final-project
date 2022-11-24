package miu.edu.dto;

import java.time.LocalDate;

import lombok.Data;
import miu.edu.model.Gender;

@Data
public abstract class PersonDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;

    private Gender gender;

    private String biography;

}

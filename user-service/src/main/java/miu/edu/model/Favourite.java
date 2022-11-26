package miu.edu.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String type;
    private String name;
    private Long favouriteId;
    private String userId;
}

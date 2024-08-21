package org.example.restro.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "item")
@JsonIgnoreProperties({"dishes"})
public class Item implements Serializable {

    @Serial
    private static final long serialVersionUID = -2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Column(name = "created_date")
    private Long createdDate;

    @Column(name = "updated_date")
    private Long updatedDate;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Dish> dishes;

}

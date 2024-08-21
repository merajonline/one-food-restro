package org.example.restro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "restaurant")
@JsonIgnoreProperties({"dishes"})
public class Restaurant implements Serializable {

    @Serial
    private static final long serialVersionUID = -3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80)
    private String name;

    @Column(length = 40)
    private String email;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(name = "overall_rating", precision = 1)
    private Double overAllRating;

    @Column(name = "max_item_processing_cap")
    private Integer maxItemProcessingCap;

    @Column(name = "curr_item_processing_cap")
    private Integer currItemProcessingCap;

    @Column(name = "status", columnDefinition = "TINYINT")
    private Integer status;

    @Column(name = "restro_manager")
    private Long restroManager;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Column(name = "video_url", length = 255)
    private String videoUrl;

    @Column(name = "created_date")
    private Long createdDate;

    @Column(name = "updated_date")
    private Long updatedDate;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Dish> dishes;

    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonBackReference("restaurant-address")
    private RestroAddress address;

}

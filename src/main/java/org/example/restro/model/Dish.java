package org.example.restro.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "dish")
public class Dish implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price; //double(10,2)

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Column(name = "video_url", length = 255)
    private String videoUrl;

    @Column(name = "created_date")
    private Long createdDate;

    @Column(name = "updated_date")
    private Long updatedDate;

    @Column(name = "availability_status")
    private int availabilityStatus;

    @ManyToOne()
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne()
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

}


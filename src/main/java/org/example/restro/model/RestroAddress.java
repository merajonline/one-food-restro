package org.example.restro.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "restro_address")
public class RestroAddress implements Serializable {

    @Serial
    private static final long serialVersionUID = -4L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "line_1")
    private String line1;

    @Column(name = "line_2")
    private String line2;

    private String city;

    private String district;

    private String state;

    private String country;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "created_date")
    private Long createdDate;

    @Column(name = "updated_date")
    private Long updatedDate;

    @OneToOne()
    @MapsId
    @JoinColumn(name = "id")
    @JsonManagedReference("restaurant-address")
    private Restaurant restaurant;

}
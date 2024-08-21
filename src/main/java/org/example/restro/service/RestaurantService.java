package org.example.restro.service;

import org.example.restro.model.Restaurant;

public interface RestaurantService {

    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant getRestaurant(Long id);
    Restaurant updateRestaurant(Restaurant restaurant);

}

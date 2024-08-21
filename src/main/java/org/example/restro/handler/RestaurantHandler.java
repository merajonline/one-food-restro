package org.example.restro.handler;

import org.example.restro.model.Restaurant;


public interface RestaurantHandler {

    Restaurant createRestaurant(Restaurant restaurant);
    Restaurant getRestaurant(Long id);
    Restaurant updateRestaurant(Restaurant restaurant);

}

package org.example.restro.handler.impl;

import lombok.RequiredArgsConstructor;
import org.example.restro.handler.RestaurantHandler;
import org.example.restro.model.Restaurant;
import org.example.restro.service.RestaurantService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantHandlerImp implements RestaurantHandler {

    private final RestaurantService restaurantService;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @Override
    public Restaurant getRestaurant(Long id) {
        return restaurantService.getRestaurant(id);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return restaurantService.updateRestaurant(restaurant);
    }

}

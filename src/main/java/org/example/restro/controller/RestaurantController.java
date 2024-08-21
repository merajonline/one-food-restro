package org.example.restro.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.restro.handler.RestaurantHandler;
import org.example.restro.model.ApiConverter;
import org.example.restro.model.Restaurant;
import org.example.restro.model.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1/api/restaurant")
public class RestaurantController {

    public final RestaurantHandler restaurantHandler;

    @PostMapping(value = "/add")
    public Result<Restaurant> addRestaurant(@Validated @RequestBody Restaurant restaurant) {
        log.info("into addRestaurant");
        return ApiConverter.toResult(restaurantHandler.createRestaurant(restaurant));
    }

    @GetMapping(value = "/get/{id}")
    public Result<Restaurant> getRestaurant(@Validated @PathVariable(value = "id") Long id) {
        log.info("into getRestaurant");
        return ApiConverter.toResult(restaurantHandler.getRestaurant(id));
    }

    @PutMapping(value = "/update")
    public Result<Restaurant> updateRestaurant(@Validated @RequestBody Restaurant restaurant) {
        log.info("into updateRestaurant");
        return ApiConverter.toResult(restaurantHandler.updateRestaurant(restaurant));
    }



}

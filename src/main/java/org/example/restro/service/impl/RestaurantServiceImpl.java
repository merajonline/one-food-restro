package org.example.restro.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.restro.exception.BixException;
import org.example.restro.model.Restaurant;
import org.example.restro.repository.RestaurantRepository;
import org.example.restro.service.RestaurantService;
import org.example.restro.util.CustomBeanUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.example.restro.exception.CommonApiResultCode.*;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        if (Objects.isNull(restaurant)) {
            throw new BixException(INVALID_RESRTAURANT);
        }
        long currentTime = System.currentTimeMillis();
        restaurant.setCreatedDate(currentTime);
        restaurant.setUpdatedDate(currentTime);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurant(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Restaurant updateRestaurant(Restaurant restaurant) {
        Restaurant restaurantDb =  restaurantRepository.findById(restaurant.getId()).orElse(null);
        if (Objects.nonNull(restaurantDb)) {
            CustomBeanUtils.copyNonNullProperties(restaurant, restaurantDb);
        } else {
            throw BixException.of(INVALID_RESTRO_ID);
        }
        return restaurantRepository.saveAndFlush(restaurantDb);
    }
}

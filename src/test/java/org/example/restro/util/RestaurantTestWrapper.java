package org.example.restro.util;

import lombok.RequiredArgsConstructor;
import org.example.restro.repository.RestaurantRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantTestWrapper {

    private final RestaurantRepository restaurantRepository;

    public void deletedAll() {
        restaurantRepository.deleteAll();
    }
}

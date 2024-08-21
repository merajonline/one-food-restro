package org.example.restro.util;

import lombok.RequiredArgsConstructor;
import org.example.restro.repository.DishRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DishTestWrapper {

    private final DishRepository dishRepository;

    public void deletedAll() {
        dishRepository.deleteAll();
    }
}

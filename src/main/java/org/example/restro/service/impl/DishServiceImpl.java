package org.example.restro.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.restro.enums.DishAvailabilityStatus;
import org.example.restro.exception.BixException;
import org.example.restro.model.Dish;
import org.example.restro.repository.DishRepository;
import org.example.restro.service.DishService;
import org.example.restro.util.CustomBeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static org.example.restro.exception.CommonApiResultCode.INVALID_DISH_ID;

@RequiredArgsConstructor
@Service
public class DishServiceImpl implements DishService {

    public final DishRepository dishRepository;

    @Override
    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish getDish(Long id) {
        return dishRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Dish updateDish(Dish dish) {
        Dish dishFromDb = dishRepository.findById(dish.getId()).orElse(null);
        if (Objects.nonNull(dishFromDb)) {
            CustomBeanUtils.copyNonNullProperties(dish, dishFromDb);
        } else {
            throw BixException.of(INVALID_DISH_ID);
        }
        return dishRepository.saveAndFlush(dish);
    }

    @Override
    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }

    @Override
    public List<Dish> getDishByItemIds(List<Long> itemIds) {
        return dishRepository.findAllByItemIdInAndAvailabilityStatus(itemIds, DishAvailabilityStatus.AVAILABLE.getValue());
    }

    @Override
    public List<Dish> getDishByRestroId(Long itemId) {
        return dishRepository.findAllByRestaurantId(itemId);
    }

}

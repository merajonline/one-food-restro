package org.example.restro.service;

import org.example.restro.model.Dish;

import java.util.List;

public interface DishService {

    Dish addDish(Dish dish);
    Dish getDish(Long id);
    Dish updateDish(Dish dish);
    void deleteDish(Long id);
    List<Dish> getDishByItemIds(List<Long> itemIds);
    List<Dish> getDishByRestroId(Long itemId);

}

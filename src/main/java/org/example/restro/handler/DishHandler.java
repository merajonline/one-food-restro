package org.example.restro.handler;

import org.example.restro.dto.DishResponseDto;
import org.example.restro.model.Dish;

import java.util.List;

public interface DishHandler {

    Dish addDish(Dish dish);
    Dish getDish(Long id);
    Dish updateDish(Dish dish);
    void deleteDish(Long id);
    List<Dish> getDishByRestroId(Long id);
    DishResponseDto  getDishByItemIds(List<Long> itemIds);

}

package org.example.restro.handler.impl;

import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.restro.dto.DishResponseDto;
import org.example.restro.handler.DishHandler;
import org.example.restro.model.Dish;
import org.example.restro.service.DishService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DishHandlerImpl implements DishHandler {

    public final DishService dishService;

    @Override
    public Dish addDish(Dish dish) {
        return dishService.addDish(dish);
    }

    @Override
    public Dish getDish(Long id) {
        return dishService.getDish(id);
    }

    @Override
    public Dish updateDish(Dish dish) {
        return dishService.updateDish(dish);
    }

    @Override
    public void deleteDish(Long id) {
        dishService.deleteDish(id);
    }

    @Override
    public List<Dish> getDishByRestroId(Long id) {
        return dishService.getDishByRestroId(id);
    }

    @Override
    public DishResponseDto  getDishByItemIds(List<Long> itemIds) {
        return getDishResponseDtoList(dishService.getDishByItemIds(itemIds));
    }

    private DishResponseDto getDishResponseDtoList(List<Dish> dishes) {
        List<DishResponseDto.DishDto> dishDtoList = new ArrayList<>();
        for(Dish dish : dishes) {
            DishResponseDto.DishDto dto = DishResponseDto.DishDto.builder()
                    .id(dish.getId())
                    .price(dish.getPrice())
                    .dishAvailabilityStatus(dish.getAvailabilityStatus())
                    .restaurantId(dish.getRestaurant().getId())
                    .restaurantStatus(dish.getRestaurant().getStatus())
                    .restaurantRating(dish.getRestaurant().getOverAllRating())
                    .currItemProcessingCap(dish.getRestaurant().getCurrItemProcessingCap())
                    .maxItemProcessingCap(dish.getRestaurant().getMaxItemProcessingCap())
                    .itemId(dish.getItem().getId())
                    .itemName(dish.getItem().getName())
                    .build();
            dishDtoList.add(dto);
        }
        DishResponseDto dishResponseDto = DishResponseDto.builder().dishDtos(dishDtoList).build();
        log.info("dishDtoList----->{}, data----- {}", dishDtoList.size(), JSON.toJSONString(dishResponseDto.getDishDtos()));
        return dishResponseDto;
    }

}

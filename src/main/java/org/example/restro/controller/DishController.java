package org.example.restro.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.restro.dto.DishResponseDto;
import org.example.restro.dto.ItemIdsDto;
import org.example.restro.handler.DishHandler;
import org.example.restro.model.ApiConverter;
import org.example.restro.model.Dish;
import org.example.restro.model.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1/api/restaurant/dish")
public class DishController {

    public final DishHandler dishHandler;

    @PostMapping(value = "/add")
    public Result<Dish> addDish(@Validated @RequestBody Dish dish) {
        log.info("into addDish");
        return ApiConverter.toResult(dishHandler.addDish(dish));
    }

    @GetMapping(value = "/get/{id}")
    public Result<Dish> getDish(@Validated @PathVariable(value = "id")  Long id) {
        log.info("into getItems");
        return ApiConverter.toResult(dishHandler.getDish(id));
    }

    @PutMapping(value = "/update")
    public Result<Dish> updateDish(@Validated @RequestBody Dish dish) {
        log.info("into updateDish");
        return ApiConverter.toResult(dishHandler.updateDish(dish));
    }

    @DeleteMapping(value = "/delete/{id}")
    public Result<String> deleteDish(@Validated @PathVariable(value = "id")  Long id) {
        log.info("into deleteDish");
        dishHandler.deleteDish(id);
        return ApiConverter.toResult("success");
    }

    @PostMapping(value = "/getDishByItemId")
    public Result<DishResponseDto> getDishByItemIds(@Valid @RequestBody ItemIdsDto itemIdsDto) {
        log.info("into getDishByItemIds");
        return ApiConverter.toResult(dishHandler.getDishByItemIds(itemIdsDto.getItemIds()));
    }


    @GetMapping(value = "/getDishByRestroId/{id}")
    public Result<List<Dish>> getDishByRestroId(@Validated @PathVariable(value = "id")  Long id) {
        log.info("into getDishByRestroId");
        return ApiConverter.toResult(dishHandler.getDishByRestroId(id));
    }

}

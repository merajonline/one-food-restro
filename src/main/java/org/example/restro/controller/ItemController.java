package org.example.restro.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.restro.handler.ItemHandler;
import org.example.restro.model.ApiConverter;
import org.example.restro.model.Item;
import org.example.restro.model.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1/api/restaurant/item")
public class ItemController {

    public final ItemHandler itemHandler;

    @PostMapping(value = "/add")
    public Result<Item> addItem(@Validated @RequestBody Item item) {
        log.info("into addRestaurant");
        return ApiConverter.toResult(itemHandler.addItem(item));
    }

    @PostMapping(value = "/getItemsByIds")
    public Result<List<Item>> getItems(@Validated @RequestBody List<Long> ids) {
        log.info("into getItems");
        return ApiConverter.toResult(itemHandler.getItems(ids));
    }

    @GetMapping(value = "/getAllItems")
    public Result<List<Item>> getAllItems() {
        log.info("into getAllItems");
        return ApiConverter.toResult(itemHandler.getAllItems());
    }

    @PutMapping(value = "/update")
    public Result<Item> updateItem(@Validated @RequestBody Item item) {
        log.info("into update");
        return ApiConverter.toResult(itemHandler.updateItem(item));
    }

}

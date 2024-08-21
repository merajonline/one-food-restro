package org.example.restro.handler.impl;

import lombok.RequiredArgsConstructor;
import org.example.restro.handler.ItemHandler;
import org.example.restro.model.Item;
import org.example.restro.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemHandlerImpl implements ItemHandler {

    public final ItemService itemService;

    @Override
    public Item addItem(Item item) {
        return itemService.addItem(item);
    }

    @Override
    public List<Item> getItems(List<Long> ids) {
        return itemService.getItems(ids);
    }

    @Override
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @Override
    public Item updateItem(Item item) {
        return itemService.updateItem(item);
    }
}

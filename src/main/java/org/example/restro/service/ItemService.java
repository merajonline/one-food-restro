package org.example.restro.service;

import org.example.restro.model.Item;

import java.util.List;

public interface ItemService {

    Item addItem(Item item);

    List<Item> getItems(List<Long> ids);

    List<Item> getAllItems();

    Item updateItem(Item item);

}

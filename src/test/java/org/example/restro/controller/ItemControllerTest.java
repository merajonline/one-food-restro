package org.example.restro.controller;

import org.example.restro.dto.ItemIdsDto;
import org.example.restro.model.Item;
import org.example.restro.service.ItemService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        System.out.println("before");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after");
    }

    @Test
    public void adduser() {
        System.out.println("adduser");
        Item item = new Item();
        itemService.addItem(item);
        System.out.println("adduser2");
        ItemIdsDto idsDto = new ItemIdsDto();
        idsDto.setItemIds(null);
        System.out.println(idsDto);
        Assertions.assertEquals(idsDto.getItemIds(), null);

    }

}
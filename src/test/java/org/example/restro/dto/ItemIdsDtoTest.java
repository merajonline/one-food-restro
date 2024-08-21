package org.example.restro.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemIdsDtoTest {


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
        ItemIdsDto idsDto = new ItemIdsDto();
        idsDto.setItemIds(null);
        System.out.println(idsDto);
        Assertions.assertEquals(idsDto.getItemIds(), null);

    }
}
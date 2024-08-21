package org.example.restro.controller;

import org.example.restro.dto.DishResponseDto;
import org.example.restro.dto.ItemIdsDto;
import org.example.restro.handler.DishHandler;
import org.example.restro.model.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;


public class DishControllerTest {

    @InjectMocks
    private DishController dishController;

    @Mock
    public DishHandler dishHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        System.out.println("before each test");
    }

    @Test
    public void testGetDishByItemId() {

        ItemIdsDto idsDto = new ItemIdsDto();
        idsDto.setItemIds(null);
        when(dishHandler.getDishByItemIds(idsDto.getItemIds())).thenReturn(null);
        Result<DishResponseDto> result =  dishController.getDishByItemIds(idsDto);
        Assertions.assertTrue(result.isSuccess());

    }

}
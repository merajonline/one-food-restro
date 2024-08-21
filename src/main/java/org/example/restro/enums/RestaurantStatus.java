package org.example.restro.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RestaurantStatus {

    CLOSE(0),
    OPEN(1);

    private final int value;

}

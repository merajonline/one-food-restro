package org.example.restro.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DishAvailabilityStatus {

    NOT_AVAILABLE(0),
    AVAILABLE(1);

    private final int value;

}

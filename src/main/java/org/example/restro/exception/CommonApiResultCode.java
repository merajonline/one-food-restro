package org.example.restro.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.restro.model.ResultCode;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CommonApiResultCode implements ResultCode {


    CUSTOM_ERROR("-1", "Oops something wrong happened", HttpStatus.INTERNAL_SERVER_ERROR),
    SUCCESS("1001", "Success", HttpStatus.OK),
    INVALID_DISH_ID("1002", "Dish id not valid", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_DISH("1003", "Dish not valid", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_RESRTO_ADDRESS_ID("1004", "Restro Address id not valid", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_RESRTO_ADDRESS("1005", "Restro Address not valid", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_RESRTAURANT("1006", "Restaurant not valid", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_ITEM_ID("1072", "Item id not valid", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_RESTRO_ID("1008", "Restro id not valid", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_ITEM("1009", "Item not valid", HttpStatus.INTERNAL_SERVER_ERROR),
    ;

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

}

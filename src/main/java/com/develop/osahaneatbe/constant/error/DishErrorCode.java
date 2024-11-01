package com.develop.osahaneatbe.constant.error;

import org.springframework.http.HttpStatus;

import com.develop.osahaneatbe.constant.message.DishErrorMessage;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum DishErrorCode implements BaseErrorCode {
    DISH_NOT_FOUND(404, DishErrorMessage.DISH_NOT_FOUND, HttpStatus.NOT_FOUND),
    DISH_ALREADY_EXISTS(400, DishErrorMessage.DISH_ALREADY_EXISTS, HttpStatus.BAD_REQUEST),
    NAME_NOT_BLANK(400, DishErrorMessage.NAME_NOT_BLANK, HttpStatus.BAD_REQUEST),
    NAME_SIZE(400, DishErrorMessage.NAME_SIZE, HttpStatus.BAD_REQUEST),
    NAME_INVALID(400, DishErrorMessage.NAME_INVALID, HttpStatus.BAD_REQUEST),
    DESCRIPTION_SIZE(400, DishErrorMessage.DESCRIPTION_SIZE, HttpStatus.BAD_REQUEST),
    PRICE_NOT_NULL(400, DishErrorMessage.PRICE_NOT_NULL, HttpStatus.BAD_REQUEST),
    PRICE_NEGATIVE(400, DishErrorMessage.PRICE_NEGATIVE, HttpStatus.BAD_REQUEST);

    private final int code;
    private final String message;
    private final HttpStatus httpStatus;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
package com.develop.osahaneatbe.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import com.develop.osahaneatbe.constant.message.RestaurantErrorMessage;
import com.develop.osahaneatbe.validator.OpenCloseTimeValidator;

@Constraint(validatedBy = OpenCloseTimeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidOpenCloseTime {
    String message() default RestaurantErrorMessage.CLOSE_BEFORE_OPEN;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
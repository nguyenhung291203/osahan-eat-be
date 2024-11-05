package com.develop.osahaneatbe.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import com.develop.osahaneatbe.annotation.ValidOpenCloseTime;
import com.develop.osahaneatbe.dto.request.RestaurantCreationRequest;

public class OpenCloseTimeValidator implements ConstraintValidator<ValidOpenCloseTime, RestaurantCreationRequest> {

    @Override
    public boolean isValid(RestaurantCreationRequest request, ConstraintValidatorContext context) {
        if (request.getOpenTime() == null || request.getCloseTime() == null) {
            return true;
        }
        return request.getOpenTime().isBefore(request.getCloseTime());
    }
}

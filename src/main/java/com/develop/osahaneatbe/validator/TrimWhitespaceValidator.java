package com.develop.osahaneatbe.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import com.develop.osahaneatbe.annotation.TrimWhitespace;

public class TrimWhitespaceValidator implements ConstraintValidator<TrimWhitespace, String> {

    @Override
    public void initialize(TrimWhitespace constraintAnnotation) {
        // TODO document why this method is empty
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        String trimmedValue = value.trim();

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(trimmedValue).addConstraintViolation();

        return true;
    }
}
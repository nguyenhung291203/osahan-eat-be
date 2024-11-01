package com.develop.osahaneatbe.annotation;

import java.lang.annotation.*;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import com.develop.osahaneatbe.constant.message.AccountErrorMessage;
import com.develop.osahaneatbe.validator.PasswordMatchesValidator;

@Documented
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatches {
    String message() default AccountErrorMessage.PASSWORDS_NOT_MATCH;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

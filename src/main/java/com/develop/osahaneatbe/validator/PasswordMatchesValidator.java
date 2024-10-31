package com.develop.osahaneatbe.validator;

import com.develop.osahaneatbe.annotation.PasswordMatches;
import com.develop.osahaneatbe.dto.request.RegisterRequest;
import com.develop.osahaneatbe.constant.message.AccountErrorMessage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, RegisterRequest> {

    @Override
    public boolean isValid(RegisterRequest request, ConstraintValidatorContext context) {
        boolean isValid = request.getPassword() != null && request.getPassword().equals(request.getConfirmPassword());

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(AccountErrorMessage.PASSWORDS_NOT_MATCH)
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation();
        }

        return isValid;
    }
}

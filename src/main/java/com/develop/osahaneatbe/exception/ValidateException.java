package com.develop.osahaneatbe.exception;

import com.develop.osahaneatbe.constant.error.BaseErrorCode;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ValidateException extends RuntimeException {
    Map<String, String> errors;

    public ValidateException(Map<String, String> errors) {
        this.errors = errors;
    }

}

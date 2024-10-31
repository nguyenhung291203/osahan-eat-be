package com.develop.osahaneatbe.constant.error;

import org.springframework.http.HttpStatus;

public interface BaseErrorCode {
    int getCode();

    String getMessage();

    HttpStatus getHttpStatus();
}

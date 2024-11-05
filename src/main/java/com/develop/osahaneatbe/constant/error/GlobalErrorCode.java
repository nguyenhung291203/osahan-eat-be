package com.develop.osahaneatbe.constant.error;

import org.springframework.http.HttpStatus;

import com.develop.osahaneatbe.constant.message.GlobalErrorMessage;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum GlobalErrorCode implements BaseErrorCode {
    UNCATEGORIZED_EXCEPTION(500, GlobalErrorMessage.UNCATEGORIZED_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR),
    METHOD_NOT_SUPPORTED(400, GlobalErrorMessage.METHOD_NOT_SUPPORTED, HttpStatus.METHOD_NOT_ALLOWED),
    INVALID_DATA_FORMAT(422, GlobalErrorMessage.INVALID_DATA_FORMAT, HttpStatus.CONFLICT),
    UNAUTHENTICATED(401, GlobalErrorMessage.UNAUTHENTICATED, HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(403, GlobalErrorMessage.UNAUTHORIZED, HttpStatus.FORBIDDEN),
    PATH_NOT_FOUND(404, GlobalErrorMessage.PATH_NOT_FOUND, HttpStatus.NOT_FOUND),
    DATA_VALIDATION_FAILED(422, GlobalErrorMessage.DATA_VALIDATION_FAILED, HttpStatus.CONFLICT);

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

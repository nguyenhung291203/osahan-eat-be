package com.develop.osahaneatbe.constant.error;

import com.develop.osahaneatbe.constant.message.MediaErrorMessage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum MediaErrorCode implements BaseErrorCode {
    IMAGE_EMPTY(400, MediaErrorMessage.IMAGE_EMPTY, HttpStatus.BAD_REQUEST),
    IMAGE_LOAD_FAILED(500, MediaErrorMessage.IMAGE_LOAD_FAILED, HttpStatus.INTERNAL_SERVER_ERROR),
    IMAGE_TOO_LARGE(400, MediaErrorMessage.IMAGE_TOO_LARGE, HttpStatus.BAD_REQUEST),
    INVALID_IMAGE_FORMAT(422, MediaErrorMessage.INVALID_IMAGE_FORMAT, HttpStatus.CONFLICT);

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
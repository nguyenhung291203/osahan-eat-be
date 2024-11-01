package com.develop.osahaneatbe.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.develop.osahaneatbe.annotation.PasswordMatches;
import com.develop.osahaneatbe.constant.message.AccountErrorMessage;
import com.develop.osahaneatbe.constant.regexp.AccountRegexPatterns;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@PasswordMatches
@Builder
public class RegisterRequest {
    @Pattern(regexp = AccountRegexPatterns.PHONE_NUMBER_PATTERN, message = AccountErrorMessage.USERNAME_INVALID)
    @NotBlank(message = AccountErrorMessage.FULLNAME_NOT_BLANK)
    String username;

    @Size(min = 6, max = 50, message = AccountErrorMessage.PASSWORD_SIZE)
    @NotBlank(message = AccountErrorMessage.PASSWORD_NOT_BLANK)
    String password;

    @Size(min = 6, max = 50, message = AccountErrorMessage.PASSWORD_SIZE)
    @NotBlank(message = AccountErrorMessage.PASSWORD_NOT_BLANK)
    String confirmPassword;

    @Size(min = 6, max = 50, message = AccountErrorMessage.FULLNAME_SIZE)
    @NotBlank(message = AccountErrorMessage.FULLNAME_NOT_BLANK)
    String fullName;

    boolean gender = true;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    LocalDate dateOfBirth;

    String address;

    Integer roleId;
}

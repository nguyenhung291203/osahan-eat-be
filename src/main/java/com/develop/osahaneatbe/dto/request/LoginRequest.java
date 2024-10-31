package com.develop.osahaneatbe.dto.request;

import com.develop.osahaneatbe.constant.message.AccountErrorMessage;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class LoginRequest {
    @NotBlank(message = AccountErrorMessage.USERNAME_NOT_BLANK)
    String username;

    @NotBlank(message = AccountErrorMessage.PASSWORD_NOT_BLANK)
    String password;
}
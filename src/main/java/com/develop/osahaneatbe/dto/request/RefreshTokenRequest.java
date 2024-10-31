package com.develop.osahaneatbe.dto.request;

import jakarta.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class RefreshTokenRequest {
    @NotBlank(message = "Refresh token không được để trống")
    @JsonProperty("refresh_token")
    String refreshToken;
}

package com.develop.osahaneatbe.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleCreationRequest {
    @Size(min = 1, max = 50, message = "Mã code có độ dài không phù hợp")
    @NotBlank(message = "Mã code không được để trống")
    String code;

    @Size(min = 1, max = 50, message = "Tên có độ dài không phù hợp")
    @NotBlank(message = "Mã code không được để trống")
    String name;
}

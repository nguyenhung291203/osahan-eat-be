package com.develop.osahaneatbe.dto.response;

import java.time.LocalDate;

import com.develop.osahaneatbe.entity.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;
import lombok.experimental.FieldDefaults;

import static com.develop.osahaneatbe.constant.pattern.DateTimePatterns.DATE_PATTERN;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountInfoResponse extends BaseResponse {
    String id;
    String username;
    Role role;
    String fullName;
    boolean gender;
    String avatar;
    @JsonProperty("date_of_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
    LocalDate dateOfBirth;
    String address;
}

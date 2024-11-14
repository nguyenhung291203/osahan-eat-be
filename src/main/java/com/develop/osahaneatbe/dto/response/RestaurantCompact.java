package com.develop.osahaneatbe.dto.response;

import static com.develop.osahaneatbe.constant.pattern.DateTimePatterns.TIME_PATTERN;

import java.io.Serializable;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantCompact  implements Serializable {
    String id;
    String title;
    String subtitle;
    String address;
    String description;
    String image;
    Boolean isFreeShip;
    Boolean isActive;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TIME_PATTERN)
    LocalTime openTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TIME_PATTERN)
    LocalTime closeTime;
}

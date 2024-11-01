package com.develop.osahaneatbe.dto.response;

import java.time.LocalTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantCompact {
    String id;
    String title;
    String subtitle;
    String address;
    String description;
    String image;
    Boolean isFreeShip;
    Boolean isActive;
    LocalTime openTime;
    LocalTime closeTime;
}

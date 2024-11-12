package com.develop.osahaneatbe.dto.response;

import java.math.BigDecimal;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DishRestaurantResponse {
    String id;
    String name;
    String description;
    Boolean isFreeShip;
    String timeShip;
    BigDecimal price;
    String image;
    Boolean isActive;
    CategoryCompact category;
    RestaurantCompact restaurant;
}

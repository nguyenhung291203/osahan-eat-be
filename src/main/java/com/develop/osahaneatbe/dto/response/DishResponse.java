package com.develop.osahaneatbe.dto.response;

import java.math.BigDecimal;
import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DishResponse extends BaseResponse {
    String id;
    String name;
    String description;
    Boolean isFreeShip;
    String timeShip;
    BigDecimal price;
    String image;
    Boolean isActive;
    CategoryCompact category;
    List<RestaurantCompact> restaurants;
}

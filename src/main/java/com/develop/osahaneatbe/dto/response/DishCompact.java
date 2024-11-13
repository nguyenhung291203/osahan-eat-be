package com.develop.osahaneatbe.dto.response;

import java.math.BigDecimal;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DishCompact {
    String id;
    String name;
    String description;
    Boolean isFreeShip;
    BigDecimal timeShip;
    BigDecimal price;
    String image;
    Boolean isActive;
    CategoryCompact category;
}

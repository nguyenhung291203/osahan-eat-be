package com.develop.osahaneatbe.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItemResponse {
    String id;

    DishCompact dish;

    RestaurantCompact restaurant;

    Long quantity;
}

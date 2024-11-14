package com.develop.osahaneatbe.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItemResponse implements Serializable {
    String id;

    DishCompact dish;

    RestaurantCompact restaurant;

    Long quantity;
}

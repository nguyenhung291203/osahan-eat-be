package com.develop.osahaneatbe.dto.request;

import jakarta.validation.constraints.NotNull;

import com.develop.osahaneatbe.annotation.Trimmed;
import com.develop.osahaneatbe.constant.message.DishErrorMessage;
import com.develop.osahaneatbe.constant.message.RestaurantErrorMessage;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Trimmed
@Builder
public class CartItemRequest {
    @NotNull(message = DishErrorMessage.ID_NOT_BLANK)
    String dishId;

    @NotNull(message = RestaurantErrorMessage.ID_NOT_BLANK)
    String restaurantId;

    @Builder.Default
    Long quantity = 1L;
}

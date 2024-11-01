package com.develop.osahaneatbe.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;

import com.develop.osahaneatbe.annotation.Trimmed;
import com.develop.osahaneatbe.constant.message.CategoryErrorMessage;
import com.develop.osahaneatbe.constant.message.DishErrorMessage;
import com.develop.osahaneatbe.constant.regexp.RegexPatterns;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Trimmed
@Builder
public class DishCreationRequest {
    @NotBlank(message = CategoryErrorMessage.NAME_NOT_BLANK)
    @Size(min = 1, max = 255, message = CategoryErrorMessage.NAME_SIZE)
    @Pattern(
            regexp = RegexPatterns.ALPHANUMERIC_WITH_SPACES_AND_VIETNAMESE_ACCENTS_PATTERN,
            message = DishErrorMessage.NAME_INVALID)
    String name;

    @Size(max = 255, message = DishErrorMessage.DESCRIPTION_SIZE)
    String description;

    Boolean isFreeShip;
    Boolean isActive;

    @NotNull(message = DishErrorMessage.PRICE_NOT_NULL)
    @PositiveOrZero(message = DishErrorMessage.PRICE_NEGATIVE)
    BigDecimal price;

    @NotBlank(message = CategoryErrorMessage.NAME_NOT_BLANK)
    String categoryId;
}

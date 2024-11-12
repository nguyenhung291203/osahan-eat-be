package com.develop.osahaneatbe.dto.request;

import com.develop.osahaneatbe.annotation.Trimmed;
import com.develop.osahaneatbe.annotation.ValidOpenCloseTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Trimmed
@ValidOpenCloseTime
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantFilterRequest {
    String accountId;
    String categoryId;

    String sortBy;

    @Builder.Default
    String sortDir = "ASC";

    Double latitude;
    Double longitude;

    @Builder.Default
    Double distance = 10.0;
}

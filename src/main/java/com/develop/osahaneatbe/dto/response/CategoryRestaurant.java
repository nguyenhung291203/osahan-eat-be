package com.develop.osahaneatbe.dto.response;

import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryRestaurant {
    String id;
    String name;
    String description;
    String image;
    List<DishCompact> dishes;
}

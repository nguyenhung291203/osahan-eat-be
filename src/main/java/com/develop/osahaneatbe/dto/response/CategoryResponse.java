package com.develop.osahaneatbe.dto.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty; // Import Jackson annotation
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryResponse extends BaseResponse implements Serializable {
    String id;
    String name;
    String description;
    String image;
    List<RestaurantCompact> restaurants;
    List<DishCompact> dishes;
}
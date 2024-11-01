package com.develop.osahaneatbe.mapper;

import org.mapstruct.Mapper;

import com.develop.osahaneatbe.dto.response.RestaurantCompact;
import com.develop.osahaneatbe.entity.Restaurant;

@Mapper(componentModel = "spring")
public abstract class RestaurantMapper {
    public abstract RestaurantCompact toRestaurantCompact(Restaurant restaurant);
}

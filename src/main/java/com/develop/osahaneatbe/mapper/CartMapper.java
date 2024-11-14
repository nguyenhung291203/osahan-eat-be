package com.develop.osahaneatbe.mapper;

import com.develop.osahaneatbe.config.AppConfig;
import com.develop.osahaneatbe.entity.CartItem;
import com.develop.osahaneatbe.entity.Dish;
import com.develop.osahaneatbe.entity.Restaurant;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import com.develop.osahaneatbe.dto.response.CartItemResponse;

@Mapper(componentModel = "spring")
public abstract class CartMapper {
    @Autowired
    protected AppConfig appConfig;

    @Autowired
    protected DishMapper dishMapper;

    @Autowired
    protected RestaurantMapper restaurantMapper;

    public abstract CartItemResponse toCartItemResponse(CartItem cartItem);

    @AfterMapping
    protected void mapCartItemResponse(CartItem cartItem, @MappingTarget CartItemResponse response) {
        Dish dish = cartItem.getDish();
        Restaurant restaurant = cartItem.getRestaurant();
        response.setDish(dishMapper.toDishCompact(dish));
        response.setRestaurant(restaurantMapper.toRestaurantCompact(restaurant));
    }
}

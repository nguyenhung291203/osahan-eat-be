package com.develop.osahaneatbe.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import com.develop.osahaneatbe.config.AppConfig;
import com.develop.osahaneatbe.dto.request.DishCreationRequest;
import com.develop.osahaneatbe.dto.response.DishCompact;
import com.develop.osahaneatbe.dto.response.DishResponse;
import com.develop.osahaneatbe.dto.response.DishRestaurantResponse;
import com.develop.osahaneatbe.entity.Dish;
import com.develop.osahaneatbe.entity.Restaurant;

@Mapper(componentModel = "spring")
public abstract class DishMapper {
    @Autowired
    protected AppConfig appConfig;

    public abstract Dish toDish(DishCreationRequest request);

    public abstract DishCompact toDishCompact(Dish dish);

    @Mapping(source = "dish.id", target = "id")
    @Mapping(source = "dish.name", target = "name")
    @Mapping(source = "dish.description", target = "description")
    @Mapping(source = "dish.isFreeShip", target = "isFreeShip")
    @Mapping(source = "dish.timeShip", target = "timeShip")
    @Mapping(source = "dish.price", target = "price")
    @Mapping(source = "dish.image", target = "image")
    @Mapping(source = "dish.isActive", target = "isActive")
    @Mapping(source = "restaurant", target = "restaurant")
    public abstract DishRestaurantResponse toDishRestaurantResponse(Dish dish, Restaurant restaurant);

    @Mapping(target = "restaurants", source = "category.menuRestaurants")
    public abstract DishResponse toDishResponse(Dish dish);

    @AfterMapping
    protected void mapImageUrl(Dish request, @MappingTarget DishResponse response) {
        if (request.getImage() != null && !request.getImage().isEmpty()) {
            response.setImage(appConfig.getBaseUrl() + request.getImage());
        }
    }

    @AfterMapping
    protected void mapImageUrl(Dish request, @MappingTarget DishCompact response) {
        if (request.getImage() != null && !request.getImage().isEmpty()) {
            response.setImage(appConfig.getBaseUrl() + request.getImage());
        }
    }

    @AfterMapping
    protected void mapDishRestaurantResponse(
            Dish dish, Restaurant restaurant, @MappingTarget DishRestaurantResponse response) {
        if (dish.getImage() != null && !dish.getImage().isEmpty()) {
            response.setImage(appConfig.getBaseUrl() + dish.getImage());
        }
        if (restaurant.getImage() != null && !restaurant.getImage().isEmpty()) {
            response.getRestaurant().setImage(appConfig.getBaseUrl() + dish.getImage());
        }
    }
}

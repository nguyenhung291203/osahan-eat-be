package com.develop.osahaneatbe.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.develop.osahaneatbe.config.AppConfig;
import com.develop.osahaneatbe.dto.request.CategoryCreationRequest;
import com.develop.osahaneatbe.dto.response.CategoryCompact;
import com.develop.osahaneatbe.dto.response.CategoryResponse;
import com.develop.osahaneatbe.dto.response.CategoryRestaurant;
import com.develop.osahaneatbe.entity.Category;
import com.develop.osahaneatbe.entity.Dish;
import com.develop.osahaneatbe.entity.MenuRestaurant;
import com.develop.osahaneatbe.entity.Restaurant;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {
    @Autowired
    protected AppConfig appConfig;

    @Autowired
    protected DishMapper dishMapper;

    @Lazy
    @Autowired
    protected RestaurantMapper restaurantMapper;

    public abstract Category toCategory(CategoryCreationRequest request);

    public abstract CategoryResponse toCategoryResponse(Category category);

    public abstract CategoryCompact toCategoryCompact(Category category);

    public abstract CategoryRestaurant toCategoryRestaurant(Category category);

    @AfterMapping
    protected void mapCategoryResponse(Category request, @MappingTarget CategoryResponse response) {
        List<Dish> dishes = request.getDishes();
        response.setDishes(dishes.stream().map(dishMapper::toDishCompact).toList());
        List<Restaurant> restaurants = request.getMenuRestaurants().stream()
                .map(MenuRestaurant::getRestaurant)
                .toList();
        response.setRestaurants(
                restaurants.stream().map(restaurantMapper::toRestaurantCompact).toList());
        if (request.getImage() != null && !request.getImage().isEmpty()) {
            response.setImage(appConfig.getBaseUrl() + request.getImage());
        }
    }

    @AfterMapping
    protected void mapCategoryRestaurant(Category request, @MappingTarget CategoryRestaurant response) {
        List<Dish> dishes = request.getDishes();
        response.setDishes(dishes.stream().map(dishMapper::toDishCompact).toList());
        if (request.getImage() != null && !request.getImage().isEmpty()) {
            response.setImage(appConfig.getBaseUrl() + request.getImage());
        }
    }
}

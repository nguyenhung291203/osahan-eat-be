package com.develop.osahaneatbe.mapper;

import com.develop.osahaneatbe.config.AppConfig;
import com.develop.osahaneatbe.dto.request.DishCreationRequest;
import com.develop.osahaneatbe.dto.response.DishCompact;
import com.develop.osahaneatbe.dto.response.DishResponse;
import com.develop.osahaneatbe.entity.Dish;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class DishMapper {
    @Autowired
    protected AppConfig appConfig;

    public abstract Dish toDish(DishCreationRequest request);

    public abstract DishCompact toDishCompact(Dish dish);

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
}

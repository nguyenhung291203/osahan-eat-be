package com.develop.osahaneatbe.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import com.develop.osahaneatbe.config.AppConfig;
import com.develop.osahaneatbe.dto.request.CategoryCreationRequest;
import com.develop.osahaneatbe.dto.response.CategoryCompact;
import com.develop.osahaneatbe.dto.response.CategoryResponse;
import com.develop.osahaneatbe.entity.Category;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {
    @Autowired
    protected AppConfig appConfig;

    public abstract Category toCategory(CategoryCreationRequest request);

    @Mapping(target = "restaurants", source = "menuRestaurants")
    @Mapping(target = "dishes", source = "dishes")
    public abstract CategoryResponse toCategoryResponse(Category category);

    public abstract CategoryCompact categoryCompact(Category category);

    @AfterMapping
    protected void mapImageUrl(Category request, @MappingTarget CategoryResponse response) {
        if (request.getImage() != null && !request.getImage().isEmpty()) {
            response.setImage(appConfig.getBaseUrl() + request.getImage());
        }
    }
}

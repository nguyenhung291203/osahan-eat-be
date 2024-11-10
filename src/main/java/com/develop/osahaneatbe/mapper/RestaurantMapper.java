package com.develop.osahaneatbe.mapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import com.develop.osahaneatbe.config.AppConfig;
import com.develop.osahaneatbe.dto.request.RestaurantCreationRequest;
import com.develop.osahaneatbe.dto.response.RestaurantCompact;
import com.develop.osahaneatbe.dto.response.RestaurantResponse;
import com.develop.osahaneatbe.entity.Category;
import com.develop.osahaneatbe.entity.MenuRestaurant;
import com.develop.osahaneatbe.entity.RatingRestaurant;
import com.develop.osahaneatbe.entity.Restaurant;

@Mapper(componentModel = "spring")
public abstract class RestaurantMapper {
    @Autowired
    protected AppConfig appConfig;

    @Autowired
    protected DishMapper dishMapper;

    @Autowired
    protected CategoryMapper categoryMapper;

    public abstract RestaurantCompact toRestaurantCompact(Restaurant restaurant);

    public abstract Restaurant toRestaurant(RestaurantCreationRequest request);

    public abstract RestaurantResponse toRestaurantResponse(Restaurant restaurant);

    @AfterMapping
    protected void mapImageUrl(Restaurant request, @MappingTarget RestaurantCompact response) {
        if (request.getImage() != null && !request.getImage().isEmpty()) {
            response.setImage(appConfig.getBaseUrl() + request.getImage());
        }
    }

    @AfterMapping
    protected void mapImageUrl(Restaurant request, @MappingTarget RestaurantResponse response) {
        if (request.getImage() != null && !request.getImage().isEmpty()) {
            response.setImage(appConfig.getBaseUrl() + request.getImage());
        }

        List<Category> categories = request.getMenRestaurants().stream()
                .map(MenuRestaurant::getCategory)
                .toList();
        response.setCategories(
                categories.stream().map(categoryMapper::toCategoryRestaurant).toList());
        response.setRating(BigDecimal.ZERO);
        response.setReviews(0L);
        if (request.getRatingRestaurants() != null
                && !request.getRatingRestaurants().isEmpty()) {
            BigDecimal totalRating = BigDecimal.ZERO;
            int totalReviews = request.getRatingRestaurants().size();

            for (RatingRestaurant rating : request.getRatingRestaurants()) {
                totalRating = totalRating.add(rating.getRating());
            }

            BigDecimal averageRating = totalRating.divide(BigDecimal.valueOf(totalReviews), 2, RoundingMode.HALF_UP);
            response.setRating(averageRating);
            response.setReviews((long) totalReviews);
        }
    }
}

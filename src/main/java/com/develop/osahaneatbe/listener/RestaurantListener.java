package com.develop.osahaneatbe.listener;

import com.develop.osahaneatbe.entity.Restaurant;
import com.develop.osahaneatbe.service.restaurant.redis.RestaurantRedisService;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RestaurantListener {
    RestaurantRedisService restaurantRedisService;
    Logger logger = LoggerFactory.getLogger(RestaurantListener.class);

    @PrePersist
    public void prePersist(Restaurant restaurant) {
        logger.info("Pre persist restaurant: {}", restaurant);
    }

    @PostPersist
    public void postPersist(Restaurant restaurant) {
        logger.info("Post persist restaurant: {}", restaurant);
        restaurantRedisService.clear();
    }

    @PreUpdate
    public void preUpdate(Restaurant restaurant) {
        logger.info("Pre update restaurant: {}", restaurant);
    }

    @PostUpdate
    public void postUpdate(Restaurant restaurant) {
        logger.info("Post update restaurant: {}", restaurant);
        restaurantRedisService.clear();
    }

    @PreRemove
    public void preRemove(Restaurant restaurant) {
        logger.info("Pre delete restaurant: {}", restaurant);
    }

    @PostRemove
    public void postRemove(Restaurant restaurant) {
        logger.info("Post delete restaurant: {}", restaurant);
        restaurantRedisService.clear();
    }
}
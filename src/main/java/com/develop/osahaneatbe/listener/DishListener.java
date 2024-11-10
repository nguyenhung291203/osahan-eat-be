package com.develop.osahaneatbe.listener;

import com.develop.osahaneatbe.entity.Dish;
import com.develop.osahaneatbe.service.dish.redis.DishRedisService;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DishListener {
    DishRedisService dishRedisService;
    Logger logger = LoggerFactory.getLogger(DishListener.class);

    @PrePersist
    public void prePersist(Dish dish) {
        logger.info("Pre persist dish: {}", dish);
    }

    @PostPersist
    public void postPersist(Dish dish) {
        logger.info("Post persist dish: {}", dish);
        dishRedisService.clear();
    }

    @PreUpdate
    public void preUpdate(Dish dish) {
        logger.info("Pre update dish: {}", dish);
    }

    @PostUpdate
    public void postUpdate(Dish dish) {
        logger.info("Post update dish: {}", dish);
        dishRedisService.clear();
    }

    @PreRemove
    public void preRemove(Dish dish) {
        logger.info("Pre delete dish: {}", dish);
    }

    @PostRemove
    public void postRemove(Dish dish) {
        logger.info("Post delete dish: {}", dish);
        dishRedisService.clear();
    }
}
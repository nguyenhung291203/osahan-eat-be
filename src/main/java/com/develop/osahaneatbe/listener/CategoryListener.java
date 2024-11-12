package com.develop.osahaneatbe.listener;

import jakarta.persistence.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.develop.osahaneatbe.entity.Category;
import com.develop.osahaneatbe.service.category.redis.CategoryRedisService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CategoryListener {
    CategoryRedisService categoryRedisService;
    Logger logger = LoggerFactory.getLogger(CategoryListener.class);

    @PrePersist
    public void prePersist(Category category) {
        logger.info("Pre persist category: {}", category);
    }

    @PostPersist
    public void postPersist(Category category) {
        logger.info("Post persist category: {}", category);
        categoryRedisService.clear();
    }

    @PreUpdate
    public void preUpdate(Category category) {
        logger.info("Pre update category: {}", category);
    }

    @PostUpdate
    public void postUpdate(Category category) {
        logger.info("Post update category: {}", category);
        categoryRedisService.clear();
    }

    @PreRemove
    public void preRemove(Category category) {
        logger.info("Pre delete category: {}", category);
    }

    @PostRemove
    public void postRemove(Category category) {
        logger.info("Post delete category: {}", category);
        categoryRedisService.clear();
    }
}

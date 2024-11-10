package com.develop.osahaneatbe.service.category.redis;

import com.develop.osahaneatbe.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryRedisService {
    void clear();

    List<CategoryResponse> findAllCategories();

    void saveAllCategories(List<CategoryResponse> categories);
}

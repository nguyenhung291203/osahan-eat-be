package com.develop.osahaneatbe.service.category.redis;

import java.util.List;

import com.develop.osahaneatbe.dto.response.CategoryResponse;

public interface CategoryRedisService {
    void clear();

    List<CategoryResponse> findAllCategories();

    void saveAllCategories(List<CategoryResponse> categories);
}

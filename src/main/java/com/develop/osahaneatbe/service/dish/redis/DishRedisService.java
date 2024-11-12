package com.develop.osahaneatbe.service.dish.redis;

import java.util.List;

import com.develop.osahaneatbe.dto.response.DishResponse;

public interface DishRedisService {
    void clear();

    List<DishResponse> findAllDishes();

    void saveAllDishes(List<DishResponse> dishes);
}

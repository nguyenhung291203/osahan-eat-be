package com.develop.osahaneatbe.service.dish.redis;

import com.develop.osahaneatbe.dto.response.DishResponse;

import java.util.List;

public interface DishRedisService {
    void clear();

    List<DishResponse> findAllDishes();


    void saveAllDishes(List<DishResponse> dishes);
}

package com.develop.osahaneatbe.service.restaurant.redis;

import java.util.List;
import java.util.Map;

import com.develop.osahaneatbe.dto.request.RestaurantFilterRequest;
import com.develop.osahaneatbe.dto.response.PageResponse;
import com.develop.osahaneatbe.dto.response.RestaurantResponse;

public interface RestaurantRedisService {
    void clear();

    List<RestaurantResponse> find();

    PageResponse<RestaurantResponse> find(Map<String, Object> params, RestaurantFilterRequest request);

    void save(List<RestaurantResponse> restaurants);

    void save(
            Map<String, Object> params, RestaurantFilterRequest request, PageResponse<RestaurantResponse> restaurants);
}

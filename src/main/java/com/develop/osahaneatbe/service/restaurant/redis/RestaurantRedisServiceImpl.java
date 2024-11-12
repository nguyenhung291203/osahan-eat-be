package com.develop.osahaneatbe.service.restaurant.redis;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.develop.osahaneatbe.dto.request.RestaurantFilterRequest;
import com.develop.osahaneatbe.dto.response.PageResponse;
import com.develop.osahaneatbe.dto.response.RestaurantResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RestaurantRedisServiceImpl implements RestaurantRedisService {
    RedisTemplate<String, Object> redisTemplate;
    ObjectMapper redisObjectMapper;
    String keyFindAllRestaurants = "KEY_FIND_ALL_RESTAURANTS";

    private String getKey(Map<String, Object> params, RestaurantFilterRequest request) {
        StringBuilder keyBuilder = new StringBuilder("restaurant_filter:");
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            keyBuilder
                    .append(entry.getKey())
                    .append("=")
                    .append(entry.getValue())
                    .append("&");
        }
        if (request.getAccountId() != null) {
            keyBuilder.append("accountId=").append(request.getAccountId()).append("&");
        }
        if (request.getLatitude() != null) {
            keyBuilder.append("latitude=").append(request.getLatitude()).append("&");
        }
        if (request.getLongitude() != null) {
            keyBuilder.append("longitude=").append(request.getLongitude()).append("&");
        }
        if (request.getDistance() != null) {
            keyBuilder.append("distance=").append(request.getDistance()).append("&");
        }
        if (request.getSortBy() != null) {
            keyBuilder.append("sortBy=").append(request.getSortBy()).append("&");
        }
        if (request.getSortDir() != null) {
            keyBuilder.append("sortDir=").append(request.getSortDir()).append("&");
        }

        if (!keyBuilder.isEmpty() && keyBuilder.charAt(keyBuilder.length() - 1) == '&') {
            keyBuilder.deleteCharAt(keyBuilder.length() - 1);
        }

        return keyBuilder.toString();
    }

    @Override
    public void clear() {
        Objects.requireNonNull(redisTemplate.getConnectionFactory())
                .getConnection()
                .flushAll();
    }

    @Override
    public List<RestaurantResponse> find() {
        String json = (String) redisTemplate.opsForValue().get(keyFindAllRestaurants);
        try {
            return json != null ? redisObjectMapper.readValue(json, new TypeReference<>() {}) : null;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageResponse<RestaurantResponse> find(Map<String, Object> params, RestaurantFilterRequest request) {
        String json = (String) redisTemplate.opsForValue().get(getKey(params, request));
        try {
            return json != null ? redisObjectMapper.readValue(json, new TypeReference<>() {}) : null;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(List<RestaurantResponse> restaurants) {
        String json;
        try {
            json = redisObjectMapper.writeValueAsString(restaurants);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        redisTemplate.opsForValue().set(keyFindAllRestaurants, json);
    }

    @Override
    public void save(
            Map<String, Object> params, RestaurantFilterRequest request, PageResponse<RestaurantResponse> restaurants) {
        String json;
        try {
            json = redisObjectMapper.writeValueAsString(restaurants);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        redisTemplate.opsForValue().set(getKey(params, request), json);
    }
}

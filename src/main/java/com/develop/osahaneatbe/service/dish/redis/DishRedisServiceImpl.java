package com.develop.osahaneatbe.service.dish.redis;

import java.util.List;
import java.util.Objects;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.develop.osahaneatbe.dto.response.DishResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DishRedisServiceImpl implements DishRedisService {
    RedisTemplate<String, Object> redisTemplate;
    ObjectMapper redisObjectMapper;
    String keyFindAllDishes = "KEY_FIND_ALL_DISHES";

    @Override
    public void clear() {
        Objects.requireNonNull(redisTemplate.getConnectionFactory())
                .getConnection()
                .flushAll();
    }

    @Override
    public List<DishResponse> findAllDishes() {
        String json = (String) redisTemplate.opsForValue().get(keyFindAllDishes);
        try {
            return json != null ? redisObjectMapper.readValue(json, new TypeReference<>() {}) : null;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAllDishes(List<DishResponse> dishes) {
        String json;
        try {
            json = redisObjectMapper.writeValueAsString(dishes);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        redisTemplate.opsForValue().set(keyFindAllDishes, json);
    }
}

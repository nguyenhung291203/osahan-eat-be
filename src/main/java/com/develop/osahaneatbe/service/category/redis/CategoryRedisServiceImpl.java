package com.develop.osahaneatbe.service.category.redis;

import com.develop.osahaneatbe.dto.response.CategoryResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CategoryRedisServiceImpl implements CategoryRedisService {
    RedisTemplate<String, Object> redisTemplate;
    ObjectMapper redisObjectMapper;
    String keyFindAllCategories = "KEY_FIND_ALL_CATEGORIES";

    @Override
    public void clear() {
        Objects.requireNonNull(redisTemplate.getConnectionFactory())
                .getConnection()
                .flushAll();
    }

    @Override
    public List<CategoryResponse> findAllCategories() {

        String json = (String) redisTemplate.opsForValue().get(keyFindAllCategories);
        try {
            return json != null
                    ? redisObjectMapper.readValue(json, new TypeReference<>() {
            })
                    : null;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAllCategories(List<CategoryResponse> categories) {
        String json;
        try {
            json = redisObjectMapper.writeValueAsString(categories);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        redisTemplate.opsForValue().set(keyFindAllCategories, json);
    }
}

package com.develop.osahaneatbe.service.dish;

import com.develop.osahaneatbe.constant.error.CategoryErrorCode;
import com.develop.osahaneatbe.constant.error.DishErrorCode;
import com.develop.osahaneatbe.constant.error.RestaurantErrorCode;
import com.develop.osahaneatbe.constant.key.CacheKey;
import com.develop.osahaneatbe.constant.message.DishErrorMessage;
import com.develop.osahaneatbe.dto.request.DishCreationRequest;
import com.develop.osahaneatbe.dto.response.DishCompact;
import com.develop.osahaneatbe.dto.response.DishResponse;
import com.develop.osahaneatbe.dto.response.DishRestaurantResponse;
import com.develop.osahaneatbe.entity.Category;
import com.develop.osahaneatbe.entity.Dish;
import com.develop.osahaneatbe.entity.MenuRestaurant;
import com.develop.osahaneatbe.entity.Restaurant;
import com.develop.osahaneatbe.exception.ApiException;
import com.develop.osahaneatbe.exception.ValidateException;
import com.develop.osahaneatbe.mapper.DishMapper;
import com.develop.osahaneatbe.repository.CategoryRepository;
import com.develop.osahaneatbe.repository.DishRepository;
import com.develop.osahaneatbe.repository.RestaurantRepository;
import com.develop.osahaneatbe.service.media.MediaService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DishServiceImpl implements DishService {
    DishRepository dishRepository;
    DishMapper dishMapper;
    CategoryRepository categoryRepository;
    RestaurantRepository restaurantRepository;
    MediaService mediaService;

    Category getCategoryById(String id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ApiException(CategoryErrorCode.CATEGORY_NOT_FOUND));
    }

    Restaurant getRestaurantById(String id) {
        return restaurantRepository
                .findById(id)
                .orElseThrow(() -> new ApiException(RestaurantErrorCode.RESTAURANT_NOT_FOUND));
    }

    Dish getDishById(String id) {
        return dishRepository.findById(id).orElseThrow(() -> new ApiException(DishErrorCode.DISH_NOT_FOUND));
    }

    @Override
    @CacheEvict(value = CacheKey.DISHES_CACHE, allEntries = true)
    public Map<String, String> createDish(DishCreationRequest request) {
        if (dishRepository.existsByName(request.getName())) {
            Map<String, String> errors = new HashMap<>();
            errors.put("name", DishErrorMessage.DISH_ALREADY_EXISTS);
            throw new ValidateException(errors);
        }
        Category category = getCategoryById(request.getCategoryId());
        Dish dish = dishMapper.toDish(request);
        dish.setCategory(category);
        dishRepository.save(dish);
        return Map.of();
    }

    @Override
    @Cacheable(value = CacheKey.DISHES_CACHE)
    public List<DishResponse> findAllDishes() {
        return dishRepository.findAll().stream()
                .map(dishMapper::toDishResponse)
                .toList();
    }

    @Override
    @Cacheable(value = CacheKey.DISHES_CACHE,key = "#id")
    public DishResponse findDishById(String id) {
        Dish dish = getDishById(id);
        return dishMapper.toDishResponse(dish);
    }

    @Override
    @Transactional
    @CacheEvict(value = CacheKey.DISHES_CACHE, allEntries = true)
    public Map<String, String> uploadImage(String id, MultipartFile file) throws IOException {
        Dish dish = getDishById(id);
        String image = dish.getImage();
        if (image != null && !image.isEmpty()) {
            mediaService.deleteImage(image);
        }
        image = mediaService.uploadImage(file);
        dish.setImage(image);
        dishRepository.save(dish);
        return Map.of();
    }

    @Override
    public List<DishCompact> findAllDishesByRestaurantId(String restaurantId) {
        return List.of();
    }

    @Override
    @Cacheable(value = CacheKey.DISHES_CACHE, key = "#id + ':' + #restaurantId")
    public DishRestaurantResponse findDishByIdAndRestaurantId(String id, String restaurantId) {
        Dish dish = getDishById(id);
        Restaurant restaurant = dish.getCategory().getMenuRestaurants().stream()
                .map(MenuRestaurant::getRestaurant)
                .filter(res -> res.getId().equals(restaurantId))
                .findFirst()
                .orElseThrow(() -> new ApiException(RestaurantErrorCode.RESTAURANT_NOT_FOUND));
        return dishMapper.toDishRestaurantResponse(dish, restaurant);
    }
}

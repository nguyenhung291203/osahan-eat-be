package com.develop.osahaneatbe.service.dish;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.develop.osahaneatbe.constant.error.CategoryErrorCode;
import com.develop.osahaneatbe.constant.error.DishErrorCode;
import com.develop.osahaneatbe.constant.message.DishErrorMessage;
import com.develop.osahaneatbe.dto.request.DishCreationRequest;
import com.develop.osahaneatbe.dto.response.DishResponse;
import com.develop.osahaneatbe.entity.Category;
import com.develop.osahaneatbe.entity.Dish;
import com.develop.osahaneatbe.exception.ApiException;
import com.develop.osahaneatbe.exception.ValidateException;
import com.develop.osahaneatbe.mapper.DishMapper;
import com.develop.osahaneatbe.repository.CategoryRepository;
import com.develop.osahaneatbe.repository.DishRepository;
import com.develop.osahaneatbe.service.media.MediaService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DishServiceImpl implements DishService {
    DishRepository dishRepository;
    DishMapper dishMapper;
    CategoryRepository categoryRepository;
    MediaService mediaService;

    private Category getCategoryById(String id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ApiException(CategoryErrorCode.CATEGORY_NOT_FOUND));
    }

    private Dish getDishById(String id) {
        return dishRepository.findById(id).orElseThrow(() -> new ApiException(DishErrorCode.DISH_NOT_FOUND));
    }

    @Override
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
    public List<DishResponse> findAllDishes() {
        return dishRepository.findAll().stream().map(dishMapper::toDishResponse).toList();
    }

    @Override
    public DishResponse findDishById(String id) {
        Dish dish = getDishById(id);
        return dishMapper.toDishResponse(dish);
    }

    @Override
    @Transactional
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
}

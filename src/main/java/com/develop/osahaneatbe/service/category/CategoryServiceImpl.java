package com.develop.osahaneatbe.service.category;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.develop.osahaneatbe.constant.error.CategoryErrorCode;
import com.develop.osahaneatbe.constant.message.CategoryErrorMessage;
import com.develop.osahaneatbe.dto.request.CategoryCreationRequest;
import com.develop.osahaneatbe.dto.response.CategoryResponse;
import com.develop.osahaneatbe.entity.Category;
import com.develop.osahaneatbe.exception.ApiException;
import com.develop.osahaneatbe.exception.ValidateException;
import com.develop.osahaneatbe.mapper.CategoryMapper;
import com.develop.osahaneatbe.repository.CategoryRepository;
import com.develop.osahaneatbe.service.category.redis.CategoryRedisService;
import com.develop.osahaneatbe.service.category.redis.CategoryRedisServiceImpl;
import com.develop.osahaneatbe.service.media.MediaService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImpl implements CategoryService {
    CategoryRedisService categoryRedisService;
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;
    MediaService mediaService;
    private final CategoryRedisServiceImpl categoryRedisServiceImpl;

    private Category getCategoryById(String id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ApiException(CategoryErrorCode.CATEGORY_NOT_FOUND));
    }

    @Override
    public Map<String, String> createCategory(CategoryCreationRequest request) {
        if (categoryRepository.existsByName(request.getName())) {
            Map<String, String> errors = Map.of("name", CategoryErrorMessage.CATEGORY_ALREADY_EXISTS);
            throw new ValidateException(errors);
        }
        Category category = categoryMapper.toCategory(request);
        categoryRepository.save(category);
        return Map.of();
    }

    @Override
    @Transactional
    public Map<String, String> uploadImage(String categoryId, MultipartFile file) throws IOException {
        Category category = getCategoryById(categoryId);
        String image = category.getImage();
        if (image != null && !image.isEmpty()) {
            mediaService.deleteImage(image);
        }
        image = mediaService.uploadImage(file);
        category.setImage(image);
        categoryRepository.save(category);
        return Map.of();
    }

    @Override
    public List<CategoryResponse> findAllCategories() {
        //        return categoryRepository.findAll().stream()
        //                .map(categoryMapper::toCategoryResponse)
        //                .toList();
        List<CategoryResponse> response = categoryRedisService.findAllCategories();
        if (response == null) {
            response = categoryRepository.findAll().stream()
                    .map(categoryMapper::toCategoryResponse)
                    .toList();
            categoryRedisService.saveAllCategories(response);
        }
        return response;
    }

    @Override
    public CategoryResponse findCategoryById(String categoryId) {
        return categoryMapper.toCategoryResponse(this.getCategoryById(categoryId));
    }
}

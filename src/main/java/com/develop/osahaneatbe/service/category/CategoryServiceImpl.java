package com.develop.osahaneatbe.service.category;

import com.develop.osahaneatbe.constant.error.CategoryErrorCode;
import com.develop.osahaneatbe.constant.key.CacheKey;
import com.develop.osahaneatbe.constant.message.CategoryErrorMessage;
import com.develop.osahaneatbe.dto.request.CategoryCreationRequest;
import com.develop.osahaneatbe.dto.response.CategoryResponse;
import com.develop.osahaneatbe.entity.Category;
import com.develop.osahaneatbe.exception.ApiException;
import com.develop.osahaneatbe.exception.ValidateException;
import com.develop.osahaneatbe.mapper.CategoryMapper;
import com.develop.osahaneatbe.repository.CategoryRepository;
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
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;
    MediaService mediaService;

    Category getCategoryById(String id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ApiException(CategoryErrorCode.CATEGORY_NOT_FOUND));
    }

    @CacheEvict(value = CacheKey.CATEGORIES_CACHE, key = "#categoryId")
    public void evictCategoryCache(String categoryId) {
    }

    @Override
    @CacheEvict(value = CacheKey.CATEGORIES_CACHE, allEntries = true)
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
    @CacheEvict(value = CacheKey.CATEGORIES_CACHE, allEntries = true)
    public Map<String, String> uploadImage(String categoryId, MultipartFile file) throws IOException {
        Category category = getCategoryById(categoryId);
        String image = category.getImage();
        if (image != null && !image.isEmpty()) {
            mediaService.deleteImage(image);
        }
        image = mediaService.uploadImage(file);
        category.setImage(image);
        categoryRepository.save(category);
        evictCategoryCache(categoryId);
        return Map.of();
    }

    @Override
    @Cacheable(value = CacheKey.CATEGORIES_CACHE)
    public List<CategoryResponse> findAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toCategoryResponse)
                .toList();
    }

    @Override
    @Cacheable(value = CacheKey.CATEGORIES_CACHE, key = "#categoryId")
    public CategoryResponse findCategoryById(String categoryId) {
        return categoryMapper.toCategoryResponse(this.getCategoryById(categoryId));
    }


}

package com.develop.osahaneatbe.service.category;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.develop.osahaneatbe.dto.request.CategoryCreationRequest;
import com.develop.osahaneatbe.dto.response.CategoryResponse;

public interface CategoryService {
    Map<String, String> createCategory(CategoryCreationRequest request);

    Map<String, String> uploadImage(String categoryId, MultipartFile file) throws IOException;

    List<CategoryResponse> findAllCategories();

    CategoryResponse findCategoryById(String categoryId);
}

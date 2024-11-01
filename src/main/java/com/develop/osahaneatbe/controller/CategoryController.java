package com.develop.osahaneatbe.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.develop.osahaneatbe.dto.request.CategoryCreationRequest;
import com.develop.osahaneatbe.dto.response.ApiResponse;
import com.develop.osahaneatbe.dto.response.CategoryResponse;
import com.develop.osahaneatbe.service.category.CategoryService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("${api.prefix}/categories")
@RequiredArgsConstructor
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryController {
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse<Map<String, String>>> createCategory(
            @RequestBody @Valid CategoryCreationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok(categoryService.createCategory(request)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponse>>> findAllCategories() {
        return ResponseEntity.ok(ApiResponse.ok(categoryService.findAllCategories()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponse>> findCategoryById(@PathVariable @Valid String id) {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.ok(categoryService.findCategoryById(id)));
    }

    @PostMapping("/upload-image/{id}")
    public ResponseEntity<ApiResponse<Map<String, String>>> uploadImage(
            @RequestParam("file") MultipartFile file, @PathVariable @Valid String id) throws IOException {
        return ResponseEntity.ok(ApiResponse.ok(categoryService.uploadImage(id, file)));
    }
}

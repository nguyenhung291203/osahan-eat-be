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

import com.develop.osahaneatbe.dto.request.DishCreationRequest;
import com.develop.osahaneatbe.dto.response.ApiResponse;
import com.develop.osahaneatbe.dto.response.DishResponse;
import com.develop.osahaneatbe.service.dish.DishService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("${api.prefix}/dishes")
@RequiredArgsConstructor
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DishController {
    DishService dishService;

    @PostMapping
    public ResponseEntity<ApiResponse<Map<String, String>>> createDish(
            @RequestBody @Valid DishCreationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok(dishService.createDish(request)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<DishResponse>>> findAllDishes() {
        return ResponseEntity.ok(ApiResponse.ok(dishService.findAllDishes()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DishResponse>> findDishById(@PathVariable @Valid String id) {
        return ResponseEntity.ok(ApiResponse.ok(dishService.findDishById(id)));
    }

    @PostMapping("/upload-image/{id}")
    public ResponseEntity<ApiResponse<Map<String, String>>> uploadImage(
            @RequestParam("file") MultipartFile file, @PathVariable @Valid String id) throws IOException {
        return ResponseEntity.ok(ApiResponse.ok(dishService.uploadImage(id, file)));
    }
}

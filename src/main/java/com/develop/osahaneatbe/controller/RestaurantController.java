package com.develop.osahaneatbe.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.develop.osahaneatbe.dto.request.RestaurantCreationRequest;
import com.develop.osahaneatbe.dto.request.RestaurantFilterRequest;
import com.develop.osahaneatbe.dto.response.ApiResponse;
import com.develop.osahaneatbe.dto.response.CustomUserDetails;
import com.develop.osahaneatbe.dto.response.PageResponse;
import com.develop.osahaneatbe.dto.response.RestaurantResponse;
import com.develop.osahaneatbe.service.restaurant.RestaurantService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("${api.prefix}/restaurants")
@RequiredArgsConstructor
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RestaurantController {
    RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<ApiResponse<Map<String, String>>> createRestaurant(
            @Valid @RequestBody RestaurantCreationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(restaurantService.createRestaurant(request)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<RestaurantResponse>>> findAllRestaurants() {
        return ResponseEntity.ok(ApiResponse.ok(restaurantService.findAllRestaurants()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<RestaurantResponse>> findAllRestaurants(@PathVariable @Valid String id) {
        return ResponseEntity.ok(ApiResponse.ok(restaurantService.findRestaurantById(id)));
    }

    @PostMapping("/upload-image/{id}")
    public ResponseEntity<ApiResponse<Map<String, String>>> uploadImage(
            @PathVariable @Valid String id, @RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(ApiResponse.ok(restaurantService.uploadImage(id, file)));
    }

    @PostMapping("/search")
    public ResponseEntity<ApiResponse<PageResponse<RestaurantResponse>>> findRestaurantByFilter(
            @RequestBody RestaurantFilterRequest request, @RequestParam Map<String, Object> params) {
        return ResponseEntity.ok(ApiResponse.ok(restaurantService.findRestaurantByFilter(params, request)));
    }

    @GetMapping("/favorite")
    public ResponseEntity<ApiResponse<List<RestaurantResponse>>> findFavoriteRestaurants(
            @AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(ApiResponse.ok(restaurantService.findFavorite(userDetails.getId())));
    }

    @PostMapping("/favorite/{id}")
    public ResponseEntity<ApiResponse<Map<String, String>>> changeFavoriteRestaurant(
            @AuthenticationPrincipal CustomUserDetails userDetails, @PathVariable String id) {
        return ResponseEntity.ok(ApiResponse.ok(restaurantService.changeFavorite(userDetails.getId(), id)));
    }
}

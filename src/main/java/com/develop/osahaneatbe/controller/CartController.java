package com.develop.osahaneatbe.controller;

import com.develop.osahaneatbe.dto.request.CartItemRequest;
import com.develop.osahaneatbe.dto.response.ApiResponse;
import com.develop.osahaneatbe.dto.response.CartItemResponse;
import com.develop.osahaneatbe.dto.response.CustomUserDetails;
import com.develop.osahaneatbe.service.cart.CartService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("${api.prefix}/cart")
@RequiredArgsConstructor
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartController {
    CartService cartService;

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<List<CartItemResponse>>> findCartMe(
            @AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(ApiResponse.ok(cartService.findCartById(userDetails.getId())));
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<Map<String, String>>> addItemToCart(
            @AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody @Valid CartItemRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(cartService.addItemToCart(userDetails.getId(), request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Map<String, String>>> removeItemFromCart(
            @AuthenticationPrincipal CustomUserDetails userDetails, @PathVariable String id) {
        return ResponseEntity.ok(ApiResponse.ok(cartService.removeItemFromCart(userDetails.getId(), id)));
    }
}

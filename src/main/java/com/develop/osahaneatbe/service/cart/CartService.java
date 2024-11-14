package com.develop.osahaneatbe.service.cart;

import com.develop.osahaneatbe.dto.request.CartItemRequest;
import com.develop.osahaneatbe.dto.response.CartItemResponse;

import java.util.List;
import java.util.Map;

public interface CartService {
    List<CartItemResponse> findCartById(String accountId);

    Map<String, String> addItemToCart(String accountId, CartItemRequest request);

    Map<String, String> removeItemFromCart(String accountId, String cartItemId);
}

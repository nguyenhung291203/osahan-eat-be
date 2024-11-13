package com.develop.osahaneatbe.service.cart;

import com.develop.osahaneatbe.dto.response.CartResponse;

public interface CartService {
    CartResponse findCartById(String cartId);
}

package com.develop.osahaneatbe.mapper;

import com.develop.osahaneatbe.dto.response.CartItemResponse;
import com.develop.osahaneatbe.dto.response.CartResponse;
import com.develop.osahaneatbe.entity.Cart;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CartMapper {
    @Autowired
    protected CartItemMapper cartItemMapper;

    public abstract CartResponse toCartResponse(Cart cart);

    @AfterMapping
    protected void mapCartResponse(Cart cart, @MappingTarget CartResponse response) {
        if (cart.getCartItems() != null) {
            List<CartItemResponse> items = cart.getCartItems().stream().map(item -> cartItemMapper.toCartItemResponse(item)).toList();
            response.setItems(items);
        }
    }
}

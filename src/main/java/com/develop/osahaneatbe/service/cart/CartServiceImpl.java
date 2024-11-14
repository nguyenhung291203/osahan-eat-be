package com.develop.osahaneatbe.service.cart;

import com.develop.osahaneatbe.constant.error.AccountErrorCode;
import com.develop.osahaneatbe.constant.error.CartItemErrorCode;
import com.develop.osahaneatbe.constant.error.DishErrorCode;
import com.develop.osahaneatbe.constant.error.RestaurantErrorCode;
import com.develop.osahaneatbe.constant.key.CacheKey;
import com.develop.osahaneatbe.dto.request.CartItemRequest;
import com.develop.osahaneatbe.dto.response.CartItemResponse;
import com.develop.osahaneatbe.entity.*;
import com.develop.osahaneatbe.exception.ApiException;
import com.develop.osahaneatbe.mapper.CartMapper;
import com.develop.osahaneatbe.repository.AccountRepository;
import com.develop.osahaneatbe.repository.CartItemRepository;
import com.develop.osahaneatbe.repository.DishRepository;
import com.develop.osahaneatbe.repository.RestaurantRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@EnableCaching
public class CartServiceImpl implements CartService {
    AccountRepository accountRepository;
    DishRepository dishRepository;
    RestaurantRepository restaurantRepository;
    CartMapper cartMapper;
    CartItemRepository cartItemRepository;

    Account getAccountById(String id) {
        return accountRepository.findById(id).orElseThrow(() -> new ApiException(AccountErrorCode.ACCOUNT_NOT_EXISTED));
    }

    Dish getDishById(String id) {
        return dishRepository.findById(id).orElseThrow(() -> new ApiException(DishErrorCode.DISH_NOT_FOUND));
    }

    Restaurant getRestaurant(String id, Dish dish) {
        return dish.getCategory().getMenuRestaurants().stream()
                .map(MenuRestaurant::getRestaurant)
                .filter(res -> res.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ApiException(RestaurantErrorCode.RESTAURANT_NOT_FOUND));
    }

    @Override
    @Cacheable(value = CacheKey.CART_CACHE, key = "#accountId")
    public List<CartItemResponse> findCartById(String accountId) {
        Account account = getAccountById(accountId);
        return account.getItems().stream().map(cartMapper::toCartItemResponse).toList();
    }

    @Transactional
    void updateCart(CartItem cartItem) {
        if (cartItem.getQuantity() < 0) {
            throw new ApiException(CartItemErrorCode.CART_ITEM_DELETE_FAILED);
        }

        if (cartItem.getQuantity() == 0) {
            cartItemRepository.delete(cartItem);
            return;
        }

        cartItemRepository.save(cartItem);
    }

    @Override
    @Transactional
    @CacheEvict(value = CacheKey.CART_CACHE, key = "#accountId")
    public Map<String, String> addItemToCart(String accountId, CartItemRequest request) {
        Account account = getAccountById(accountId);
        Dish dish = getDishById(request.getDishId());
        Restaurant restaurant = getRestaurant(request.getRestaurantId(), dish);
        CartItem cartItem = account.getItems().stream()
                .filter(item -> item.getDish().getId().equals(dish.getId())
                        && item.getRestaurant().getId().equals(restaurant.getId()))
                .findFirst()
                .orElse(null);

        if (cartItem != null) {
            cartItem.setQuantity(request.getQuantity() + cartItem.getQuantity());
            updateCart(cartItem);
            return Map.of();
        }

        cartItem = CartItem.builder()
                .account(account)
                .dish(dish)
                .quantity(request.getQuantity())
                .restaurant(restaurant)
                .build();
        updateCart(cartItem);

        return Map.of();
    }

    @Override
    @Transactional
    @CacheEvict(value = CacheKey.CART_CACHE, key = "#accountId")
    public Map<String, String> removeItemFromCart(String accountId, String cartItemId) {
        Account account = getAccountById(accountId);
        CartItem cartItem = account.getItems().stream()
                .filter(item -> item.getId().equals(cartItemId))
                .findFirst()
                .orElseThrow(() -> new ApiException(CartItemErrorCode.CART_ITEM_NOT_FOUND));
        account.getItems().remove(cartItem);
        cartItemRepository.delete(cartItem);

        return Map.of();
    }
}

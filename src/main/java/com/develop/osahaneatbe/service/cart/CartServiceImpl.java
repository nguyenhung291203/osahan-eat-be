package com.develop.osahaneatbe.service.cart;


import com.develop.osahaneatbe.constant.error.AccountErrorCode;
import com.develop.osahaneatbe.dto.response.CartResponse;
import com.develop.osahaneatbe.entity.Account;
import com.develop.osahaneatbe.entity.Cart;
import com.develop.osahaneatbe.exception.ApiException;
import com.develop.osahaneatbe.mapper.CartMapper;
import com.develop.osahaneatbe.repository.AccountRepository;
import com.develop.osahaneatbe.repository.CartRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartServiceImpl implements CartService {
    AccountRepository accountRepository;
    CartRepository cartRepository;
    CartMapper cartMapper;

    Account getAccountById(String id) {
        return accountRepository.findById(id).orElseThrow(() -> new ApiException(AccountErrorCode.ACCOUNT_NOT_EXISTED));
    }

    @Override
    public CartResponse findCartById(String cartId) {
        Account account = getAccountById(cartId);
        Cart cart = account.getCart();

        if (cart == null) {
            cart = Cart.builder()
                    .cartItems(List.of())
                    .account(account)
                    .build();
            cart = cartRepository.save(cart);
        }

        return cartMapper.toCartResponse(cart);
    }
}

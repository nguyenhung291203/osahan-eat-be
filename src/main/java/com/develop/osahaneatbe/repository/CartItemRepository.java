package com.develop.osahaneatbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.osahaneatbe.entity.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, String> {}

package com.develop.osahaneatbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.osahaneatbe.entity.MenuRestaurant;

@Repository
public interface MenuRestaurantRepository extends JpaRepository<MenuRestaurant, String> {}

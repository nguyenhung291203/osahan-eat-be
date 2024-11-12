package com.develop.osahaneatbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.osahaneatbe.entity.FavoriteRestaurant;

@Repository
public interface FavoriteRestaurantRepository extends JpaRepository<FavoriteRestaurant, String> {}

package com.develop.osahaneatbe.repository;

import com.develop.osahaneatbe.entity.FavoriteRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRestaurantRepository extends JpaRepository<FavoriteRestaurant, String> {
    FavoriteRestaurant findFavoriteRestaurantByAccountIdAndRestaurantId(String accountId, String restaurantId);
}

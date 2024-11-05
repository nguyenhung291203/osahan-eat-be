package com.develop.osahaneatbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.osahaneatbe.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
    boolean existsByTitle(String title);

    boolean existsByAddress(String address);
}

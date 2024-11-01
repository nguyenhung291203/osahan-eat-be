package com.develop.osahaneatbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.osahaneatbe.entity.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, String> {
    boolean existsByName(String name);
}

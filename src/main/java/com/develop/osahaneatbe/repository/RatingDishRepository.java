package com.develop.osahaneatbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.osahaneatbe.entity.RatingDish;

@Repository
public interface RatingDishRepository extends JpaRepository<RatingDish, String> {}

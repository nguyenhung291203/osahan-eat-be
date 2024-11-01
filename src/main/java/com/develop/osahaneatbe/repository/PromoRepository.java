package com.develop.osahaneatbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.osahaneatbe.entity.Promo;

@Repository
public interface PromoRepository extends JpaRepository<Promo, String> {}

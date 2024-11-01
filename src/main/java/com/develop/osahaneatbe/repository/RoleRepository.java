package com.develop.osahaneatbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develop.osahaneatbe.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    boolean existsByName(String name);

    boolean existsByCode(String code);

    boolean existsById(int id);

    Role findByCode(String code);
}

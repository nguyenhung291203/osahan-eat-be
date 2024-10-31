package com.develop.osahaneatbe.repository;

import com.develop.osahaneatbe.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    boolean existsByName(String name);

    boolean existsByCode(String code);

    boolean existsById(int id);

    Role findByCode(String code);
}

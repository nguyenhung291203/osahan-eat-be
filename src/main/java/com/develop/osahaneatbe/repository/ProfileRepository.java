package com.develop.osahaneatbe.repository;

import com.develop.osahaneatbe.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {}

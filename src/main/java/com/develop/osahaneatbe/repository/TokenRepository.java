package com.develop.osahaneatbe.repository;

import com.develop.osahaneatbe.entity.Account;
import com.develop.osahaneatbe.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TokenRepository extends JpaRepository<Token, String> {
    List<Token> findAllByAccount(Account account);

    Optional<Token> findTokenByRefreshToken(String refreshToken);

    boolean existsByToken(String token);

    Optional<Token> findByToken(String token);

    Optional<Token> findTokenByToken(String token);
}

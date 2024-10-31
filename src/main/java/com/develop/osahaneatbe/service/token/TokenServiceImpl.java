package com.develop.osahaneatbe.service.token;

import com.develop.osahaneatbe.component.JwtTokenProvider;
import com.develop.osahaneatbe.constant.error.AccountErrorCode;
import com.develop.osahaneatbe.constant.error.BaseErrorCode;
import com.develop.osahaneatbe.constant.error.TokenErrorCode;
import com.develop.osahaneatbe.dto.request.RefreshTokenRequest;
import com.develop.osahaneatbe.dto.response.TokenResponse;
import com.develop.osahaneatbe.entity.Account;
import com.develop.osahaneatbe.entity.Token;
import com.develop.osahaneatbe.exception.ApiException;
import com.develop.osahaneatbe.mapper.TokenMapper;
import com.develop.osahaneatbe.repository.AccountRepository;
import com.develop.osahaneatbe.repository.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TokenServiceImpl implements TokenService {
    final TokenRepository tokenRepository;
    final AccountRepository accountRepository;
    final JwtTokenProvider jwtTokenProvider;
    final TokenMapper tokenMapper;

    @Value("${app.jwt-expiration-milliseconds}")
    long jwtExpirationDate;

    @Value("${app.jwt-expiration-refresh-token}")
    long jwtExpirationRefreshToken;

    private Account getAccountById(String accountId) {
        return accountRepository.findById(accountId).orElseThrow(() -> new ApiException(AccountErrorCode.ACCOUNT_NOT_EXISTED));
    }

    private Token getTokenByRefreshToken(String refreshToken) {
        return tokenRepository.findTokenByRefreshToken(refreshToken).orElseThrow(() -> new ApiException(TokenErrorCode.TOKEN_NOT_FOUND));
    }

    private Token getTokenByToken(String token) {
        return tokenRepository.findTokenByToken(token).orElseThrow(() -> new ApiException(TokenErrorCode.TOKEN_NOT_FOUND));
    }


    @Override
    @Transactional
    public Token addToken(String accountId, String token) {
        Account account = getAccountById(accountId);

        Token tokenEntity = Token.builder().account(account).token(token).refreshToken(UUID.randomUUID().toString()).revoked(false).expired(false).tokenType("Bearer").expiresAt(LocalDateTime.now().plusSeconds(jwtExpirationDate / 1000)).refreshTokenExpiresAt(LocalDateTime.now().plusSeconds(jwtExpirationRefreshToken / 1000)).build();
        return tokenRepository.save(tokenEntity);

    }


    @Override
    @Transactional
    public TokenResponse refreshToken(RefreshTokenRequest request) {
        Token token = getTokenByRefreshToken(request.getRefreshToken());
        Account account = getAccountById(token.getAccount().getId());
        if (token.getRefreshTokenExpiresAt().isBefore(LocalDateTime.now())) {
            tokenRepository.delete(token);
            throw new ApiException(TokenErrorCode.REFRESH_TOKEN_EXPIRED);
        }

        token.setToken(jwtTokenProvider.generateToken(account));
        token.setExpiresAt(LocalDateTime.now().plusSeconds(jwtExpirationDate));
        token.setRefreshTokenExpiresAt(LocalDateTime.now().plusSeconds(jwtExpirationRefreshToken));
        token.setRefreshToken(UUID.randomUUID().toString());

        return tokenMapper.toTokenResponse(token);
    }

    @Override
    public BaseErrorCode validateToken(String token) {
        if (token == null) {
            return TokenErrorCode.EMPTY_TOKEN;
        }
        jwtTokenProvider.decodeToken(token);
        Token tokenEntity = getTokenByToken(token);
        if (tokenEntity.getExpiresAt() != null && tokenEntity.getExpiresAt().isBefore(LocalDateTime.now())) {
            return TokenErrorCode.TOKEN_EXPIRED;
        }
        if (tokenEntity.isRevoked()) {
            return TokenErrorCode.EMPTY_REVOKED;
        }

        return null;
    }

    @Override
    public String getTokenFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }
}

package com.develop.osahaneatbe.service.token;

import com.develop.osahaneatbe.constant.error.BaseErrorCode;
import com.develop.osahaneatbe.dto.request.RefreshTokenRequest;
import com.develop.osahaneatbe.dto.response.TokenResponse;
import com.develop.osahaneatbe.entity.Token;
import jakarta.servlet.http.HttpServletRequest;

public interface TokenService {
    Token addToken(String accountId, String token);

    TokenResponse refreshToken(RefreshTokenRequest request);

    BaseErrorCode validateToken(String token);
    String getTokenFromRequest(HttpServletRequest request);
}

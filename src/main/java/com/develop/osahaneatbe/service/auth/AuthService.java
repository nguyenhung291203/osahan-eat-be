package com.develop.osahaneatbe.service.auth;

import com.develop.osahaneatbe.dto.request.LoginRequest;
import com.develop.osahaneatbe.dto.request.RegisterRequest;
import com.develop.osahaneatbe.dto.response.TokenResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public interface AuthService {
    Map<String, String> register(RegisterRequest request);

    TokenResponse login(LoginRequest request) throws Exception;

    Map<String, String> logout(HttpServletRequest request);
}

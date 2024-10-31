package com.develop.osahaneatbe.component;

import com.develop.osahaneatbe.constant.error.AccountErrorCode;
import com.develop.osahaneatbe.constant.error.BaseErrorCode;
import com.develop.osahaneatbe.dto.response.ApiResponse;
import com.develop.osahaneatbe.entity.Account;
import com.develop.osahaneatbe.exception.ApiException;
import com.develop.osahaneatbe.repository.AccountRepository;
import com.develop.osahaneatbe.service.token.TokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    final JwtTokenProvider jwtTokenProvider;
    final UserDetailsService userDetailsService;
    final AccountRepository accountRepository;
    final TokenService tokenService;

    @Value("${api.prefix}")
    String apiPrefix;

    private void sendErrorResponse(HttpServletResponse response, BaseErrorCode errorCode) throws IOException {
        response.setStatus(errorCode.getHttpStatus().value());
        response.setContentType("application/json; charset=UTF-8");
        ApiResponse<Object> apiResponse = new ApiResponse<>(errorCode.getCode(), errorCode.getMessage());
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(apiResponse);
        response.getWriter().write(jsonResponse);
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        if (isBypassToken(request)) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = tokenService.getTokenFromRequest(request);

        BaseErrorCode error = tokenService.validateToken(token);
        if (error != null) {
            sendErrorResponse(response, error);
            return;
        }
        String accountId = jwtTokenProvider.getAccountId(token);
        Account account = accountRepository
                .findById(accountId)
                .orElseThrow(() -> new ApiException(AccountErrorCode.USERNAME_EMPTY));
        if (!account.isActive()) {
            sendErrorResponse(response, AccountErrorCode.ACCOUNT_LOCKED);
            return;
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(account.getUsername());

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

    private boolean isBypassToken(@NonNull HttpServletRequest request) {
        Map<String, String> bypassTokens = new HashMap<>();
        bypassTokens.put(String.format("%s/auth/register", apiPrefix), "POST");
        bypassTokens.put(String.format("%s/auth/login", apiPrefix), "POST");
        bypassTokens.put(String.format("%s/view", apiPrefix), "GET");

        String requestPath = request.getServletPath();
        String requestMethod = request.getMethod();

        return bypassTokens.entrySet().stream()
                .anyMatch(entry -> requestPath.startsWith(entry.getKey()) && requestMethod.equalsIgnoreCase(entry.getValue()));
    }

}

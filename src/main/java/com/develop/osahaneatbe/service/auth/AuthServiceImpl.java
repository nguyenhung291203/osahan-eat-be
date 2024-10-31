package com.develop.osahaneatbe.service.auth;

import com.develop.osahaneatbe.component.JwtTokenProvider;
import com.develop.osahaneatbe.constant.code.RoleCode;
import com.develop.osahaneatbe.constant.error.AccountErrorCode;
import com.develop.osahaneatbe.constant.error.RoleErrorCode;
import com.develop.osahaneatbe.constant.error.TokenErrorCode;
import com.develop.osahaneatbe.constant.message.AccountErrorMessage;
import com.develop.osahaneatbe.dto.request.LoginRequest;
import com.develop.osahaneatbe.dto.request.RegisterRequest;
import com.develop.osahaneatbe.dto.response.TokenResponse;
import com.develop.osahaneatbe.entity.Account;
import com.develop.osahaneatbe.entity.Profile;
import com.develop.osahaneatbe.entity.Role;
import com.develop.osahaneatbe.entity.Token;
import com.develop.osahaneatbe.exception.ApiException;
import com.develop.osahaneatbe.exception.ValidateException;
import com.develop.osahaneatbe.mapper.AccountMapper;
import com.develop.osahaneatbe.mapper.ProfileMapper;
import com.develop.osahaneatbe.mapper.TokenMapper;
import com.develop.osahaneatbe.repository.AccountRepository;
import com.develop.osahaneatbe.repository.ProfileRepository;
import com.develop.osahaneatbe.repository.RoleRepository;
import com.develop.osahaneatbe.repository.TokenRepository;
import com.develop.osahaneatbe.service.token.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthServiceImpl implements AuthService {
    RoleRepository roleRepository;
    AccountRepository accountRepository;
    ProfileRepository profileRepository;
    TokenRepository tokenRepository;
    AccountMapper accountMapper;
    PasswordEncoder passwordEncoder;
    AuthenticationManager authenticationManager;
    TokenService tokenService;
    JwtTokenProvider jwtTokenProvider;
    TokenMapper tokenMapper;
    ProfileMapper profileMapper;

    private Role getRoleById(int id) {
        return roleRepository.findById(id).orElseThrow(() -> new ApiException(RoleErrorCode.ROLE_NOT_FOUND));
    }

    private Token getTokenByToken(String token) {
        return tokenRepository.findByToken(token).orElseThrow(() -> new ApiException(TokenErrorCode.TOKEN_NOT_FOUND));
    }

    @Override
    public Map<String, String> register(RegisterRequest request) {
        if (accountRepository.existsAccountByUsername(request.getUsername())) {
            Map<String, String> errors = Map.of("username", AccountErrorMessage.ACCOUNT_EXISTED);
            throw new ValidateException(errors);
        }

        request.setRoleId(
                request.getRoleId() == null
                        ? roleRepository.findByCode(RoleCode.CUSTOMER).getId()
                        : request.getRoleId());
        Account account = accountMapper.toAccount(request);
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        Role role = getRoleById(request.getRoleId());
        account.setRole(role);
        account.setActive(true);
        accountRepository.save(account);
        Profile profile = profileMapper.toProfile(request);
        profile.setDateOfBirth(LocalDate.now());
        profile.setAccount(account);

        profileRepository.save(profile);

        return Map.of();

    }

    @Override
    public TokenResponse login(LoginRequest request) throws Exception {
        Map<String, String> errors = new HashMap<>();
        errors.put("username", AccountErrorMessage.INCORRECT_PASSWORD);
        errors.put("password", AccountErrorMessage.INCORRECT_PASSWORD);
        Exception exception = new ValidateException(errors);
        Account account = accountRepository
                .findAccountByUsername(request.getUsername())
                .orElseThrow(() -> exception);
        if (!passwordEncoder.matches(request.getPassword(), account.getPassword())) {
            throw exception;
        }

        if (!account.isActive()) {
            throw new ApiException(AccountErrorCode.ACCOUNT_LOCKED);
        }

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());

        authenticationManager.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Token token = tokenService.addToken(account.getId(), jwtTokenProvider.generateToken(account));

        return tokenMapper.toTokenResponse(token);
    }

    @Override
    public Map<String, String> logout(HttpServletRequest request) {
        String token = tokenService.getTokenFromRequest(request);

        Token existingToken = getTokenByToken(token);
        existingToken.setRevoked(true);
        tokenRepository.save(existingToken);

        SecurityContextHolder.clearContext();

        return Map.of();
    }

}

package com.develop.osahaneatbe.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.develop.osahaneatbe.dto.response.CustomUserDetails;
import com.develop.osahaneatbe.entity.Account;
import com.develop.osahaneatbe.repository.AccountRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository
                .findAccountByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return CustomUserDetails.toCustomUserDetails(account);
    }
}

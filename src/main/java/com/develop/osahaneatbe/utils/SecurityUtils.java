package com.develop.osahaneatbe.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.develop.osahaneatbe.dto.response.CustomUserDetails;
import com.develop.osahaneatbe.entity.Account;

public class SecurityUtils {

    private SecurityUtils() {}

    public static CustomUserDetails getCustomUserDetails() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails) {
            return (CustomUserDetails) principal;
        }

        return null;
    }

    public static Account getAccount() {
        CustomUserDetails customUserDetails = getCustomUserDetails();
        if (customUserDetails != null) {
            return CustomUserDetails.toAccount(customUserDetails);
        }
        return null;
    }

    public static String getUserId() {
        CustomUserDetails userDetails = getCustomUserDetails();
        return userDetails != null ? userDetails.getId() : null;
    }

    public static String getUserName() {
        CustomUserDetails userDetails = getCustomUserDetails();
        return userDetails != null ? userDetails.getUsername() : null;
    }
}

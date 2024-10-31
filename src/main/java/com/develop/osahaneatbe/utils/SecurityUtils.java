package com.develop.osahaneatbe.utils;

import com.develop.osahaneatbe.entity.Account;
import com.develop.osahaneatbe.entity.Role;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    private SecurityUtils() {}

    public static Account getAccount() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return (Account) securityContext.getAuthentication().getPrincipal();
    }

    public static String getUserId() {
        return getAccount().getId();
    }

    public static String getUserName() {
        return getAccount().getUsername();
    }

    public static Role getRole() {
        return getAccount().getRole();
    }
}

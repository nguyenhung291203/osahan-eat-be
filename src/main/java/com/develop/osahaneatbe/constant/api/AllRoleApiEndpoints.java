package com.develop.osahaneatbe.constant.api;

import com.develop.osahaneatbe.constant.code.RoleCode;
import com.develop.osahaneatbe.dto.response.ProtectedEndpoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AllRoleApiEndpoints {

    private static final String[] ALL_ROLES = {RoleCode.CUSTOMER, RoleCode.IT_ADMIN, RoleCode.MANAGER, RoleCode.EMPLOYEE
    };

    @Value("${api.prefix}")
    private String apiPrefix;

    public List<ProtectedEndpoint> getEndpoints() {
        return Arrays.asList(
                new ProtectedEndpoint(String.format("%s/auth/logout", apiPrefix), HttpMethod.POST, ALL_ROLES),
                new ProtectedEndpoint(String.format("%s/accounts/me", apiPrefix), HttpMethod.GET, ALL_ROLES),
                new ProtectedEndpoint(
                        String.format("%s/accounts/{id}/upload-avatar", apiPrefix), HttpMethod.POST, ALL_ROLES),
                new ProtectedEndpoint(String.format("%s/cart/me", apiPrefix), HttpMethod.GET, ALL_ROLES),
                new ProtectedEndpoint(String.format("%s/cart", apiPrefix), HttpMethod.POST, ALL_ROLES),
                new ProtectedEndpoint(String.format("%s/cart/{id}", apiPrefix), HttpMethod.DELETE, ALL_ROLES),
                new ProtectedEndpoint(String.format("%s/restaurants/favorite", apiPrefix), HttpMethod.GET, ALL_ROLES),
                new ProtectedEndpoint(String.format("%s/restaurants/favorite", apiPrefix), HttpMethod.POST, ALL_ROLES));
    }
}

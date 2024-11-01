package com.develop.osahaneatbe.constant.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.develop.osahaneatbe.constant.code.RoleCode;
import com.develop.osahaneatbe.dto.response.ProtectedEndpoint;

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
                        String.format("%s/accounts/{id}/upload-avatar", apiPrefix), HttpMethod.POST, ALL_ROLES));
    }
}

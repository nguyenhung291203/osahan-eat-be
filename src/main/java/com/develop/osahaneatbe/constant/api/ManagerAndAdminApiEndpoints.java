package com.develop.osahaneatbe.constant.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.develop.osahaneatbe.constant.code.RoleCode;
import com.develop.osahaneatbe.dto.response.ProtectedEndpoint;

@Component
public class ManagerAndAdminApiEndpoints {
    private static final String[] ADMIN_MANAGER_ROLES = {RoleCode.IT_ADMIN, RoleCode.MANAGER};

    @Value("${api.prefix}")
    private String apiPrefix;

    public List<ProtectedEndpoint> getEndpoints() {
        return Arrays.asList(
                new ProtectedEndpoint(String.format("%s/categories", apiPrefix), HttpMethod.POST, ADMIN_MANAGER_ROLES),
                new ProtectedEndpoint(
                        String.format("%s/categories/upload-image/{id}", apiPrefix),
                        HttpMethod.POST,
                        ADMIN_MANAGER_ROLES),
                new ProtectedEndpoint(
                        String.format("%s/dishes/upload-image/{id}", apiPrefix), HttpMethod.POST, ADMIN_MANAGER_ROLES),
                new ProtectedEndpoint(String.format("%s/dishes", apiPrefix), HttpMethod.POST, ADMIN_MANAGER_ROLES),
                new ProtectedEndpoint(String.format("%s/restaurants", apiPrefix), HttpMethod.POST, ADMIN_MANAGER_ROLES),
                new ProtectedEndpoint(
                        String.format("%s/restaurants/upload-image/{id}", apiPrefix), HttpMethod.POST, ADMIN_MANAGER_ROLES));
    }
}

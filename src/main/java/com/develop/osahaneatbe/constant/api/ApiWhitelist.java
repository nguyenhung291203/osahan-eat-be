package com.develop.osahaneatbe.constant.api;

import java.util.Arrays;
import java.util.List;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.develop.osahaneatbe.dto.response.ProtectedEndpoint;

import lombok.Getter;

@Component
public class ApiWhitelist {
    @Value("${api.prefix}")
    private String apiPrefix;

    @Getter
    private List<ProtectedEndpoint> whiteListUrls;

    @PostConstruct
    public void init() {
        this.whiteListUrls = Arrays.asList(
                new ProtectedEndpoint(String.format("%s/roles", apiPrefix), HttpMethod.GET),
                new ProtectedEndpoint(String.format("%s/auth/register", apiPrefix), HttpMethod.POST),
                new ProtectedEndpoint(String.format("%s/auth/login", apiPrefix), HttpMethod.POST),
                new ProtectedEndpoint(String.format("%s/auth/refresh", apiPrefix), HttpMethod.POST),
                new ProtectedEndpoint(String.format("%s/view/**", apiPrefix), HttpMethod.GET),
                new ProtectedEndpoint(String.format("%s/categories", apiPrefix), HttpMethod.GET),
                new ProtectedEndpoint(String.format("%s/categories/{id}", apiPrefix), HttpMethod.GET),
                new ProtectedEndpoint(String.format("%s/dishes", apiPrefix), HttpMethod.GET),
                new ProtectedEndpoint(String.format("%s/dishes/{id}", apiPrefix), HttpMethod.GET));
    }

    public boolean isWhitelisted(String path, HttpMethod method) {
        return whiteListUrls.stream()
                .anyMatch(url -> {
                    String regex = url.getUrl()
                            .replace(
                                    "{id}",
                                    "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}") // Regex cho UUID
                            .replace("**", ".*");
                    return path.matches(regex) && method.equals(url.getHttpMethod());
                });
    }
}
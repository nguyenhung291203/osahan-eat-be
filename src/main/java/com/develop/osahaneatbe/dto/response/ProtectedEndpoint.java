package com.develop.osahaneatbe.dto.response;

import org.springframework.http.HttpMethod;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProtectedEndpoint {
    String url;
    HttpMethod httpMethod;
    String[] roles;

    public ProtectedEndpoint(String url, HttpMethod method, String[] roles) {
        this.httpMethod = method;
        this.roles = roles;
        this.url = url;
    }

    public ProtectedEndpoint(String url, HttpMethod method) {
        this.httpMethod = method;
        this.url = url;
        this.roles = new String[0];
    }
}

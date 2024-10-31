package com.develop.osahaneatbe.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
public class AppConfig {

    @Value("${upload.base-url}")
    private String baseUrl;
}

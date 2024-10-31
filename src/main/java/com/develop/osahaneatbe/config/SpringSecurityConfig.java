package com.develop.osahaneatbe.config;

import java.util.Arrays;
import java.util.List;

import com.develop.osahaneatbe.component.JwtAuthenticationFilter;
import com.develop.osahaneatbe.constant.code.RoleCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@Configuration
@EnableWebSecurity
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class SpringSecurityConfig {
    final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Value("${api.prefix}")
    String apiPrefix;

    private String[] getWhiteListUrls() {
        return new String[] {
            String.format("%s/roles", apiPrefix),
            String.format("%s/auth/register", apiPrefix),
            String.format("%s/auth/login", apiPrefix),
            String.format("%s/accounts/refresh", apiPrefix),
            String.format("%s/view/**", apiPrefix),
        };
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> req.requestMatchers(getWhiteListUrls())
                        .permitAll()
                        .requestMatchers(
                                String.format("%s/auth/logout", apiPrefix),
                                String.format("%s/accounts/my-info", apiPrefix),
                                String.format("%s/accounts/{id}/upload-avatar", apiPrefix))
                        .hasAnyAuthority(RoleCode.CUSTOMER, RoleCode.IT_ADMIN, RoleCode.MANAGER, RoleCode.EMPLOYEE)
                        .anyRequest()
                        .authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        http.cors(httpSecurityCorsConfigurer -> {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(List.of("*"));
            configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            configuration.setAllowedHeaders(
                    Arrays.asList("authorization", "content-type", "x-auth-token", "cache-control"));
            configuration.setExposedHeaders(List.of("x-auth-token"));
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);
            httpSecurityCorsConfigurer.configurationSource(source);
        });

        return http.build();
    }
}

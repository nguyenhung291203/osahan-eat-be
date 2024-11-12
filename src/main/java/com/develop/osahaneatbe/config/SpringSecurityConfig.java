package com.develop.osahaneatbe.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.develop.osahaneatbe.component.JwtAuthenticationFilter;
import com.develop.osahaneatbe.constant.api.AllRoleApiEndpoints;
import com.develop.osahaneatbe.constant.api.ApiWhitelist;
import com.develop.osahaneatbe.constant.api.ManagerAndAdminApiEndpoints;
import com.develop.osahaneatbe.dto.response.ProtectedEndpoint;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@Configuration
@EnableWebSecurity
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SpringSecurityConfig {
    JwtAuthenticationFilter jwtAuthenticationFilter;
    ApiWhitelist apiWhitelist;
    ManagerAndAdminApiEndpoints managerAndAdminApiEndpoints;
    AllRoleApiEndpoints allRoleApiEndpoints;

    private void permitWhiteListedUrls(
            AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry req) {
        List<ProtectedEndpoint> whiteListUrls = apiWhitelist.getWhiteListUrls();
        for (ProtectedEndpoint url : whiteListUrls) {
            req.requestMatchers(url.getHttpMethod(), url.getUrl()).permitAll();
        }
    }

    private void permitRoleBasedEndpoints(
            AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry req,
            List<ProtectedEndpoint> endpoints) {
        endpoints.forEach(endpoint ->
                req.requestMatchers(endpoint.getHttpMethod(), endpoint.getUrl()).hasAnyAuthority(endpoint.getRoles()));
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
                .authorizeHttpRequests(req -> {
                    permitWhiteListedUrls(req);
                    permitRoleBasedEndpoints(req, managerAndAdminApiEndpoints.getEndpoints());
                    permitRoleBasedEndpoints(req, allRoleApiEndpoints.getEndpoints());
                    req.anyRequest().authenticated();
                })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(
                        handling -> handling.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.NOT_FOUND)));

        return http.build();
    }
}

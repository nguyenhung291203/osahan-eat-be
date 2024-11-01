package com.develop.osahaneatbe.component;

import java.security.Key;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.develop.osahaneatbe.entity.Account;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
@RequiredArgsConstructor
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    long jwtExpirationDate;

    static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String generateToken(Account account) {
        String id = account.getId();
        Date currentDate = new Date();

        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        return Jwts.builder()
                .setSubject(id)
                .setIssuedAt(currentDate)
                .setExpiration(expireDate)
                .signWith(key())
                .compact();
    }

    public String getAccountId(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            logger.warn("Token đã hết hạn: {}", e.getMessage());
        } catch (io.jsonwebtoken.JwtException e) {
            logger.error("Token không hợp lệ: {}", e.getMessage());
        } catch (Exception e) {
            logger.error("Lỗi giải mã token: {}", e.getMessage());
        }
        return null;
    }
}

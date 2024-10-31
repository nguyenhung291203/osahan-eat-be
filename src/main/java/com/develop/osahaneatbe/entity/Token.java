package com.develop.osahaneatbe.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tokens")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String token;

    @Column(name = "token_type")
    String tokenType;

    boolean expired;
    boolean revoked;

    @Column(name = "expires_at")
    LocalDateTime expiresAt;

    @Column(name = "refresh_token")
    String refreshToken;

    @Column(name = "refresh_token_expires_at")
    LocalDateTime refreshTokenExpiresAt;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;
}

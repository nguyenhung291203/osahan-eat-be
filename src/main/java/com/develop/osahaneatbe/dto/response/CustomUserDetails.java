package com.develop.osahaneatbe.dto.response;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.develop.osahaneatbe.entity.Account;
import com.develop.osahaneatbe.entity.Role;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomUserDetails implements UserDetails {
    String id;
    String username;
    String password;
    boolean isActive;
    String facebookAccountId;
    String googleAccountId;
    private Collection<? extends GrantedAuthority> authorities;

    public static CustomUserDetails toCustomUserDetails(Account account) {
        List<SimpleGrantedAuthority> authorityList =
                List.of(new SimpleGrantedAuthority(account.getRole().getCode()));
        return CustomUserDetails.builder()
                .id(account.getId())
                .username(account.getUsername())
                .password(account.getPassword())
                .isActive(account.isActive())
                .facebookAccountId(account.getFacebookAccountId())
                .googleAccountId(account.getGoogleAccountId())
                .authorities(authorityList)
                .build();
    }

    public static Account toAccount(CustomUserDetails customUserDetails) {
        Role role = new Role();
        if (customUserDetails.getAuthorities() != null
                && !customUserDetails.getAuthorities().isEmpty()) {
            String roleCode =
                    customUserDetails.getAuthorities().iterator().next().getAuthority();
            role.setCode(roleCode);
        }

        return Account.builder()
                .id(customUserDetails.getId())
                .username(customUserDetails.getUsername())
                .password(customUserDetails.getPassword())
                .isActive(customUserDetails.isActive())
                .facebookAccountId(customUserDetails.getFacebookAccountId())
                .googleAccountId(customUserDetails.getGoogleAccountId())
                .role(role)
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}

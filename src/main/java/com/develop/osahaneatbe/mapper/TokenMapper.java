package com.develop.osahaneatbe.mapper;

import org.mapstruct.Mapper;

import com.develop.osahaneatbe.dto.response.TokenResponse;
import com.develop.osahaneatbe.entity.Token;

@Mapper(componentModel = "spring")
public interface TokenMapper {
    TokenResponse toTokenResponse(Token token);
}

package com.develop.osahaneatbe.mapper;

import com.develop.osahaneatbe.dto.response.TokenResponse;
import com.develop.osahaneatbe.entity.Token;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TokenMapper {
    TokenResponse toTokenResponse(Token token);
}

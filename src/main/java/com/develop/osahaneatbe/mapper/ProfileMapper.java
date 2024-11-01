package com.develop.osahaneatbe.mapper;

import org.mapstruct.Mapper;

import com.develop.osahaneatbe.dto.request.RegisterRequest;
import com.develop.osahaneatbe.entity.Profile;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    Profile toProfile(RegisterRequest request);
}

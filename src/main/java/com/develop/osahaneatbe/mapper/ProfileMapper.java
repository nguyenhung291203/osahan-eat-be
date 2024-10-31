package com.develop.osahaneatbe.mapper;

import com.develop.osahaneatbe.dto.request.RegisterRequest;
import com.develop.osahaneatbe.entity.Profile;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProfileMapper {
    Profile toProfile(RegisterRequest request);
}

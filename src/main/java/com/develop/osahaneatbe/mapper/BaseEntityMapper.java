package com.develop.osahaneatbe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.develop.osahaneatbe.dto.response.BaseResponse;
import com.develop.osahaneatbe.entity.BaseEntity;

@Mapper(componentModel = "spring")
public interface BaseEntityMapper {
    @Mapping(target = "createdDate", source = "createdDate")
    @Mapping(target = "updatedDate", source = "updatedDate")
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "updatedBy", source = "updatedBy")
    BaseResponse toBaseResponse(BaseEntity baseEntity);
}

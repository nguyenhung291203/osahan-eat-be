package com.develop.osahaneatbe.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Map;

public class ParamUtil {
    public static Pageable getPageable(Map<String, Object> params) {
        int page = Integer.parseInt((String) params.getOrDefault("page", "1")) - 1;

        int limit = Integer.parseInt((String) params.getOrDefault("limit", "10"));

        String sortBy = (String) params.getOrDefault("sortBy", "id");
        String sortDir = (String) params.getOrDefault("sortDir", "asc");
        Sort sort = Sort.by(sortDir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        return PageRequest.of(page, limit, sort);
    }
}
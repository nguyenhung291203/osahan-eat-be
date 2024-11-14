package com.develop.osahaneatbe.dto.response;

import java.io.Serializable;
import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageResponse<T>  implements Serializable {
    List<T> contents;
    long totalElements;
    int totalPages;
}

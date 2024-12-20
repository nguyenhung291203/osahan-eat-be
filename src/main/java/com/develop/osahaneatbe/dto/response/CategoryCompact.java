package com.develop.osahaneatbe.dto.response;

import java.io.Serializable;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryCompact implements Serializable {
    String id;
    String name;
    String description;
}

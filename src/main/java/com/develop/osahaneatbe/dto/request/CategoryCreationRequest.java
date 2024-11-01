package com.develop.osahaneatbe.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.develop.osahaneatbe.annotation.Trimmed;
import com.develop.osahaneatbe.constant.message.CategoryErrorMessage;
import com.develop.osahaneatbe.constant.regexp.RegexPatterns;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Trimmed
@Builder
public class CategoryCreationRequest {
    @NotBlank(message = CategoryErrorMessage.NAME_NOT_BLANK)
    @Size(min = 1, max = 255, message = CategoryErrorMessage.NAME_SIZE)
    @Pattern(
            regexp = RegexPatterns.ALPHANUMERIC_WITH_SPACES_AND_VIETNAMESE_ACCENTS_PATTERN,
            message = CategoryErrorMessage.NAME_INVALID)
    String name;

    @Size(message = CategoryErrorMessage.DESCRIPTION_SIZE)
    String description;
}

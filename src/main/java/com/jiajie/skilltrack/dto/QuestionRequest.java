package com.jiajie.skilltrack.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record QuestionRequest(
    @NotNull Long skillId,
    @NotBlank String prompt,
    @NotBlank String correctAnswer,
    @Min(1) @Max(5) int difficulty
) {
}

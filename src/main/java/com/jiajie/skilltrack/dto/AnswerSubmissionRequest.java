package com.jiajie.skilltrack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnswerSubmissionRequest(
    @NotNull Long questionId,
    @NotBlank String submittedAnswer
) {
}

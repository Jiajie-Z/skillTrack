package com.jiajie.skilltrack.dto;

import jakarta.validation.constraints.NotNull;

public record PracticeSessionRequest(
    @NotNull Long studentId,
    @NotNull Long skillId
) {
}

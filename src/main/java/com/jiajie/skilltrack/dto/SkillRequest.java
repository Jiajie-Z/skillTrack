package com.jiajie.skilltrack.dto;

import jakarta.validation.constraints.NotBlank;

public record SkillRequest(
    @NotBlank String name,
    @NotBlank String subject
) {
}

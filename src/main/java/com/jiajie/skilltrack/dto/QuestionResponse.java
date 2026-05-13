package com.jiajie.skilltrack.dto;

public record QuestionResponse(
    Long id,
    Long skillId,
    String prompt,
    int difficulty
) {
}

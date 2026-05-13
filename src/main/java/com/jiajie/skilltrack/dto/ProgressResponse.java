package com.jiajie.skilltrack.dto;

public record ProgressResponse(
    Long skillId,
    String skillName,
    int attempts,
    int correctAnswers,
    double masteryScore
) {
}

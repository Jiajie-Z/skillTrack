package com.jiajie.skilltrack.controller;

import com.jiajie.skilltrack.dto.StudentRequest;
import com.jiajie.skilltrack.service.LearningService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.jiajie.skilltrack.dto.SkillRequest;
import com.jiajie.skilltrack.dto.QuestionRequest;
import com.jiajie.skilltrack.dto.PracticeSessionRequest;
import com.jiajie.skilltrack.dto.AnswerResponse;
import com.jiajie.skilltrack.dto.AnswerSubmissionRequest;
import com.jiajie.skilltrack.dto.ProgressResponse;
import com.jiajie.skilltrack.dto.QuestionResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LearningController {
    private final LearningService learningService;

    public LearningController(LearningService learningService) {
        this.learningService = learningService;
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Long> createStudent(@Valid @RequestBody StudentRequest request) {
        Long id = learningService.createStudent(request);
        return Map.of("id", id);
    }

    @PostMapping("/skills")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Long> createSkill(@Valid @RequestBody SkillRequest request) {
        Long id = learningService.createSkill(request);
        return Map.of("id", id);
    }

    @PostMapping("/questions")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Long> createQuestion(@Valid @RequestBody QuestionRequest request) {
        Long id = learningService.createQuestion(request);
        return Map.of("id", id);
    }

    @PostMapping("/practice-sessions")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Long> createPracticeSession(@Valid @RequestBody PracticeSessionRequest request) {
        Long id = learningService.createPracticeSession(request);
        return Map.of("id", id);
    }

    @PostMapping("/practice-sessions/{sessionId}/answers")
    @ResponseStatus(HttpStatus.CREATED)
    public AnswerResponse submitAnswer(
            @PathVariable Long sessionId,
            @Valid @RequestBody AnswerSubmissionRequest request) {
        return learningService.submitAnswer(sessionId, request);
    }

    @GetMapping("/students/{studentId}/progress")
    public List<ProgressResponse> getProgress(@PathVariable Long studentId) {
        return learningService.getProgress(studentId);
    }

    @GetMapping("/students/{studentId}/recommendations")
    public List<QuestionResponse> getRecommendations(@PathVariable Long studentId) {
        return learningService.getRecommendations(studentId);
    }

}

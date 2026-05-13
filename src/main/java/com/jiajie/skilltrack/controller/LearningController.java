package com.jiajie.skilltrack.controller;

import com.jiajie.skilltrack.dto.StudentRequest;
import com.jiajie.skilltrack.service.LearningService;
import jakarta.validation.Valid;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.jiajie.skilltrack.dto.SkillRequest;
import com.jiajie.skilltrack.dto.QuestionRequest;

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

}

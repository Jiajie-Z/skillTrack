package com.jiajie.skilltrack.controller;

import com.jiajie.skilltrack.dto.StudentRequest;
import com.jiajie.skilltrack.service.LearningService;
import jakarta.validation.Valid;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}

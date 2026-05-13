package com.jiajie.skilltrack.service;

import com.jiajie.skilltrack.dto.StudentRequest;
import com.jiajie.skilltrack.model.Student;
import com.jiajie.skilltrack.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LearningService {
    private final StudentRepository studentRepository;

    public LearningService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Long createStudent(StudentRequest request) {
        if (studentRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("email already exists");
        }

        Student student = new Student();
        student.setName(request.name().trim());
        student.setEmail(request.email().trim().toLowerCase());

        return studentRepository.save(student).getId();
    }
}

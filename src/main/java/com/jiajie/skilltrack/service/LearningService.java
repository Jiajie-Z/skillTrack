package com.jiajie.skilltrack.service;

import com.jiajie.skilltrack.dto.StudentRequest;
import com.jiajie.skilltrack.model.Student;
import com.jiajie.skilltrack.repository.QuestionRepository;
import com.jiajie.skilltrack.repository.SkillRepository;
import com.jiajie.skilltrack.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jiajie.skilltrack.dto.SkillRequest;
import com.jiajie.skilltrack.dto.QuestionRequest;
import com.jiajie.skilltrack.model.Skill;
import com.jiajie.skilltrack.model.Question;


@Service
public class LearningService {
    private final StudentRepository studentRepository;
    private final SkillRepository skillRepository;
    private final QuestionRepository questionRepository;

    public LearningService(
            StudentRepository studentRepository,
            SkillRepository skillRepository,
            QuestionRepository questionRepository) {
        this.studentRepository = studentRepository;
        this.skillRepository = skillRepository;
        this.questionRepository = questionRepository;
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

    @Transactional
    public Long createSkill(SkillRequest request) {
        Skill skill = new Skill();
        skill.setName(request.name().trim());
        skill.setSubject(request.subject().trim());

        return skillRepository.save(skill).getId();
    }

    @Transactional
    public Long createQuestion(QuestionRequest request) {
        Skill skill = skillRepository.findById(request.skillId())
                .orElseThrow(() -> new IllegalArgumentException("skill not found"));

        Question question = new Question();
        question.setSkill(skill);
        question.setPrompt(request.prompt().trim());
        question.setCorrectAnswer(request.correctAnswer().trim().toLowerCase());
        question.setDifficulty(request.difficulty());

        return questionRepository.save(question).getId();
    }

}

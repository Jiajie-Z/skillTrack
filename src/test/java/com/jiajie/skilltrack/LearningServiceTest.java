package com.jiajie.skilltrack;

import static org.assertj.core.api.Assertions.assertThat;

import com.jiajie.skilltrack.dto.AnswerSubmissionRequest;
import com.jiajie.skilltrack.dto.PracticeSessionRequest;
import com.jiajie.skilltrack.dto.QuestionRequest;
import com.jiajie.skilltrack.dto.SkillRequest;
import com.jiajie.skilltrack.dto.StudentRequest;
import com.jiajie.skilltrack.service.LearningService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class LearningServiceTest {
    @Autowired
    private LearningService learningService;

    @Test
    void gradesAnswersAndUpdatesProgress() {
        Long studentId = learningService.createStudent(
                new StudentRequest("Jiajie Zhang", "jiajie@example.com")
        );

        Long skillId = learningService.createSkill(
                new SkillRequest("Linear equations", "Math")
        );

        Long questionId = learningService.createQuestion(
                new QuestionRequest(skillId, "Solve x + 2 = 5", "3", 1)
        );

        Long sessionId = learningService.createPracticeSession(
                new PracticeSessionRequest(studentId, skillId)
        );

        var answer = learningService.submitAnswer(
                sessionId,
                new AnswerSubmissionRequest(questionId, "3")
        );

        assertThat(answer.correct()).isTrue();

        var progress = learningService.getProgress(studentId);

        assertThat(progress).hasSize(1);
        assertThat(progress.get(0).skillId()).isEqualTo(skillId);
        assertThat(progress.get(0).attempts()).isEqualTo(1);
        assertThat(progress.get(0).correctAnswers()).isEqualTo(1);
        assertThat(progress.get(0).masteryScore()).isEqualTo(100.0);
    }

    @Test
    void recommendsQuestionsFromWeakestSkill() {
        Long studentId = learningService.createStudent(
                new StudentRequest("Test Student", "student@example.com")
        );

        Long algebraId = learningService.createSkill(
                new SkillRequest("Algebra", "Math")
        );

        Long fractionsId = learningService.createSkill(
                new SkillRequest("Fractions", "Math")
        );

        Long algebraQuestionId = learningService.createQuestion(
                new QuestionRequest(algebraId, "2 + x = 4", "2", 1)
        );

        learningService.createQuestion(
                new QuestionRequest(fractionsId, "1/2 + 1/4", "3/4", 1)
        );

        Long sessionId = learningService.createPracticeSession(
                new PracticeSessionRequest(studentId, algebraId)
        );

        learningService.submitAnswer(
                sessionId,
                new AnswerSubmissionRequest(algebraQuestionId, "wrong")
        );

        var recommendations = learningService.getRecommendations(studentId);

        assertThat(recommendations).isNotEmpty();
        assertThat(recommendations)
                .allSatisfy(question -> assertThat(question.skillId()).isEqualTo(algebraId));
    }
}

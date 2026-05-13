package com.jiajie.skilltrack.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "practice_session_id")
    private PracticeSession practiceSession;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(nullable = false)
    private String submittedAnswer;

    @Column(nullable = false)
    private boolean correct;

    @Column(nullable = false)
    private Instant submittedAt = Instant.now();

    public Long getId() {
        return id;
    }

    public PracticeSession getPracticeSession() {
        return practiceSession;
    }

    public void setPracticeSession(PracticeSession practiceSession) {
        this.practiceSession = practiceSession;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getSubmittedAnswer() {
        return submittedAnswer;
    }

    public void setSubmittedAnswer(String submittedAnswer) {
        this.submittedAnswer = submittedAnswer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Instant getSubmittedAt() {
        return submittedAt;
    }
}

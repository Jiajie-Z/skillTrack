package com.jiajie.skilltrack.repository;

import com.jiajie.skilltrack.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}

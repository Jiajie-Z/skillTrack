package com.jiajie.skilltrack.repository;

import com.jiajie.skilltrack.model.Question;
import com.jiajie.skilltrack.model.Skill;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findTop5BySkillOrderByDifficultyAsc(Skill skill);
}

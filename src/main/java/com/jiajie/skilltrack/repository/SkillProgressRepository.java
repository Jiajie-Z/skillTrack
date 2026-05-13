package com.jiajie.skilltrack.repository;

import com.jiajie.skilltrack.model.Skill;
import com.jiajie.skilltrack.model.SkillProgress;
import com.jiajie.skilltrack.model.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillProgressRepository extends JpaRepository<SkillProgress, Long> {
    Optional<SkillProgress> findByStudentAndSkill(Student student, Skill skill);

    List<SkillProgress> findByStudentOrderByMasteryScoreAsc(Student student);
}

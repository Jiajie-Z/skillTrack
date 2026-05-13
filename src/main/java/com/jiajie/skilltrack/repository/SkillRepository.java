package com.jiajie.skilltrack.repository;

import com.jiajie.skilltrack.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}

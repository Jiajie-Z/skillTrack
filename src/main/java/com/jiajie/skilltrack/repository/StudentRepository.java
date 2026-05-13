package com.jiajie.skilltrack.repository;

import com.jiajie.skilltrack.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByEmail(String email);
}

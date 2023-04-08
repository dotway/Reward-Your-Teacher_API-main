package com.decagon.reward_your_teacher.infrastructure.persistence.repository;

import com.decagon.reward_your_teacher.domain.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    Optional<StudentEntity> findStudentEntityByEmail(String email);
}

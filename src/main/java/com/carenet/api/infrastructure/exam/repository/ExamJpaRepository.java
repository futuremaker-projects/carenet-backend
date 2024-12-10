package com.carenet.api.infrastructure.exam.repository;

import com.carenet.api.infrastructure.exam.entity.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamJpaRepository extends JpaRepository<ExamEntity, Long> {
}

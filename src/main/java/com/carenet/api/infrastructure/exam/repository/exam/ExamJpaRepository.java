package com.carenet.api.infrastructure.exam.repository.exam;

import com.carenet.api.infrastructure.exam.entity.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamJpaRepository extends JpaRepository<ExamEntity, Long> {
}

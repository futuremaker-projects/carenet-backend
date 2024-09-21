package com.carenet.api.infrastructure.exam.repository;

import com.carenet.api.infrastructure.exam.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionJpaRepository extends JpaRepository<QuestionEntity, Long> {
}

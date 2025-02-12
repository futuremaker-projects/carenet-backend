package com.carenet.storage.exam.repository.exam;

import com.carenet.storage.exam.entity.exam.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionJpaRepository extends JpaRepository<QuestionEntity, Long> {
}

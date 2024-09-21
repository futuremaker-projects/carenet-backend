package com.carenet.api.infrastructure.exam.repository;

import com.carenet.api.infrastructure.exam.entity.SubmissionComplexIds;
import com.carenet.api.infrastructure.exam.entity.SubmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionJpaRepository extends JpaRepository<SubmissionEntity, SubmissionComplexIds> {
}

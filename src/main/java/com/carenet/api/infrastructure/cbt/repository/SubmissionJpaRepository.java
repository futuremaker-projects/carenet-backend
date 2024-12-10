package com.carenet.api.infrastructure.cbt.repository;

import com.carenet.api.infrastructure.cbt.entity.SubmissionComplexIds;
import com.carenet.api.infrastructure.cbt.entity.SubmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionJpaRepository extends JpaRepository<SubmissionEntity, SubmissionComplexIds> {
}

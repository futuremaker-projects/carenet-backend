package com.carenet.api.infrastructure.exam.repository;

import com.carenet.api.infrastructure.exam.entity.SubmissionHistoryComplexIds;
import com.carenet.api.infrastructure.exam.entity.SubmissionHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionHistoryJpaRepository extends JpaRepository<SubmissionHistoryEntity, SubmissionHistoryComplexIds> {
}

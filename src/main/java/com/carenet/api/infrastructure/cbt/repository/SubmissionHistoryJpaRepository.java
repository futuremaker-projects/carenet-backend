package com.carenet.api.infrastructure.cbt.repository;

import com.carenet.api.infrastructure.cbt.entity.SubmissionHistoryComplexIds;
import com.carenet.api.infrastructure.cbt.entity.SubmissionHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionHistoryJpaRepository extends JpaRepository<SubmissionHistoryEntity, SubmissionHistoryComplexIds> {
}

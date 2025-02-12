package com.carenet.storage.exam.repository.cbt;

import com.carenet.storage.exam.entity.cbt.SubmissionHistoryComplexIds;
import com.carenet.storage.exam.entity.cbt.SubmissionHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionHistoryJpaRepository extends JpaRepository<SubmissionHistoryEntity, SubmissionHistoryComplexIds> {
}

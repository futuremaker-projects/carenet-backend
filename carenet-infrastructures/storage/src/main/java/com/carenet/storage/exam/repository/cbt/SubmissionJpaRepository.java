package com.carenet.storage.exam.repository.cbt;

import com.carenet.storage.exam.entity.cbt.SubmissionComplexIds;
import com.carenet.storage.exam.entity.cbt.SubmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionJpaRepository extends JpaRepository<SubmissionEntity, SubmissionComplexIds> {
}

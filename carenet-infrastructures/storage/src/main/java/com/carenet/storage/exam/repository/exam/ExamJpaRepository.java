package com.carenet.storage.exam.repository.exam;


import com.carenet.storage.exam.entity.exam.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamJpaRepository extends JpaRepository<ExamEntity, Long> {
}

package com.carenet.storage.exam.repository;

import com.carenet.storage.exam.entity.UploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadJpaRepository extends JpaRepository<UploadEntity, Long> {
}

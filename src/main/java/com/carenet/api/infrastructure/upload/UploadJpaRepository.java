package com.carenet.api.infrastructure.upload;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadJpaRepository extends JpaRepository<UploadEntity, Long> {
}

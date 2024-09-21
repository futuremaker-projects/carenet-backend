package com.carenet.api.infrastructure.code.repository;

import com.carenet.api.infrastructure.code.entity.CodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeJpaRepository extends JpaRepository<CodeEntity, Long> {
}

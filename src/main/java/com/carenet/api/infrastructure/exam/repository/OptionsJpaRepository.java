package com.carenet.api.infrastructure.exam.repository;

import com.carenet.api.infrastructure.exam.entity.OptionsComplexIds;
import com.carenet.api.infrastructure.exam.entity.OptionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionsJpaRepository extends JpaRepository<OptionsEntity, OptionsComplexIds> {
}

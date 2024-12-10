package com.carenet.api.infrastructure.exam.repository;

import com.carenet.api.infrastructure.exam.entity.SelectionEntity;
import com.carenet.api.infrastructure.exam.entity.SelectionComplexIds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelectionJpaRepository extends JpaRepository<SelectionEntity, SelectionComplexIds> {
}

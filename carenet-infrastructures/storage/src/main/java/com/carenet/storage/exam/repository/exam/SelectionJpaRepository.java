package com.carenet.storage.exam.repository.exam;

import com.carenet.storage.exam.entity.exam.SelectionComplexIds;
import com.carenet.storage.exam.entity.exam.SelectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SelectionJpaRepository extends JpaRepository<SelectionEntity, SelectionComplexIds> {

    Optional<SelectionEntity> findByIdQuestionIdAndIdSelectionId(Long questionId, Long selectionId);

}

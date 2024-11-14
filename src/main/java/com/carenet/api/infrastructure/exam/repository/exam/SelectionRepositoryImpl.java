package com.carenet.api.infrastructure.exam.repository.exam;

import com.carenet.api.domain.exam.model.Selection;
import com.carenet.api.domain.exam.repository.SelectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SelectionRepositoryImpl implements SelectionRepository {

    private final SelectionJpaRepository selectionJpaRepository;

    @Override
    public Selection save(Selection selection) {
        return selectionJpaRepository.save(selection.toEntity()).toDomain();
    }

    @Override
    public void updateSelection(Selection selection) {
        selectionJpaRepository.save(selection.toEntity());
    }

}

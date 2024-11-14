package com.carenet.api.domain.exam.service;

import com.carenet.api.domain.exam.model.Selection;
import com.carenet.api.domain.exam.repository.SelectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SelectionService {

    private final SelectionRepository selectionRepository;

    @Transactional
    public void updateSelection(Selection selection) {
        selectionRepository.updateSelection(selection);
    }
}

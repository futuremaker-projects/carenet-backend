package com.carenet.admin.exam.service;

import com.carenet.admin.exam.dto.command.SelectionCommand;
import com.carenet.admin.exam.repository.SelectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SelectionService {

    private final SelectionRepository selectionRepository;

    @Transactional
    public void updateSelection(SelectionCommand.Update update) {
        selectionRepository.updateContent(update);
    }
}

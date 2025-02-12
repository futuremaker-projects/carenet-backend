package com.carenet.storage.exam.repository.exam;

import com.carenet.common.exception.ApplicationException;
import com.carenet.common.exception.ErrorCode;
import com.carenet.exam.exam.dto.command.SelectionCommand;
import com.carenet.exam.exam.model.Selection;
import com.carenet.exam.exam.repository.SelectionRepository;
import com.carenet.storage.exam.entity.exam.SelectionEntity;
import com.carenet.storage.exam.mapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SelectionRepositoryImpl implements SelectionRepository {

    private final SelectionJpaRepository selectionJpaRepository;

    @Override
    public Selection getSelection(SelectionCommand.Get get) {
        SelectionEntity entity = findSelection(get.questionId(), get.selectionId());
        return ModelMapper.SelectionMapper.from(entity);
    }

    @Override
    public Selection save(SelectionCommand.Create selection) {
        SelectionEntity selectionEntity = SelectionEntity.of(selection.questionId(), selection.questionId(), selection.content());
        SelectionEntity saved = selectionJpaRepository.save(selectionEntity);
        return ModelMapper.SelectionMapper.from(saved);
    }

    @Override
    public void updateContent(SelectionCommand.Update update) {
        SelectionEntity entity = findSelection(update.questionId(), update.selectionId());
        entity.updateContent(update);
    }

    private SelectionEntity findSelection(Long questionId, Long selectionId) {
        return selectionJpaRepository.findByIdQuestionIdAndIdSelectionId(questionId, selectionId)
                .orElseThrow(() -> new ApplicationException(
                        ErrorCode.CONTENT_NOT_FOUND,
                        "selection not found: questionId-%d, selectionId-%d".formatted(questionId, selectionId))
                );
    }

}

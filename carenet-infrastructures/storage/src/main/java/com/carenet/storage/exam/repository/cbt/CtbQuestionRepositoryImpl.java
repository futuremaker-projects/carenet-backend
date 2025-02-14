package com.carenet.storage.exam.repository.cbt;

import com.carenet.exam.cbt.CbtQuestionRepository;
import com.carenet.exam.cbt.dto.command.CbtQuestionCommand;
import com.carenet.exam.cbt.model.CbtQuestion;
import com.carenet.storage.exam.repository.exam.QuestionJpaQuerySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CtbQuestionRepositoryImpl implements CbtQuestionRepository {

    private final QuestionJpaQuerySupport questionJpaQuerySupport;

    @Override
    public List<CbtQuestion> getCbtQuestions(CbtQuestionCommand.Get get) {
        return List.of();
    }
}

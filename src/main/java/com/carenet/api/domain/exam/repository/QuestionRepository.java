package com.carenet.api.domain.exam.repository;

import com.carenet.api.domain.exam.model.Question;
import com.carenet.api.infrastructure.exam.dto.statement.QuestionStatement;
import com.carenet.api.interfaces.exam.dto.SearchQuestionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface QuestionRepository {
    Slice<Question> getQuestionsByExamId(Pageable pageable, QuestionStatement.Get get);
    List<Question> getQuestions(QuestionStatement.Get get);

    Long getTotalCountByExamId(SearchQuestionDto.Search search, Long examId);

    Question getQuestion(Long questionId);

    Question save(Question question);

    void updateArticle(Question question);
}

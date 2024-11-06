package com.carenet.api.domain.exam.repository;

import com.carenet.api.domain.exam.model.Question;
import com.carenet.api.infrastructure.exam.dto.statement.QuestionStatement;
import com.carenet.api.interfaces.question.dto.SearchQuestionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface QuestionRepository {

    Question save(Question question);

    Slice<Question> getQuestionsByExamId(Pageable pageable, QuestionStatement.Get get);

    Long getTotalCountByExamId(SearchQuestionDto.Search search, Long examId);

    Question getQuestion(Long questionId);
}

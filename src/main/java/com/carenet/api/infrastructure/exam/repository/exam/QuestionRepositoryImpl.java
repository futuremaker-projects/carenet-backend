package com.carenet.api.infrastructure.exam.repository.exam;

import com.carenet.api.domain.exam.model.Question;
import com.carenet.api.domain.exam.repository.QuestionRepository;
import com.carenet.api.infrastructure.exam.dto.payload.QuestionPayload;
import com.carenet.api.infrastructure.exam.dto.statement.QuestionStatement;
import com.carenet.api.infrastructure.exam.entity.QuestionEntity;
import com.carenet.api.interfaces.question.dto.SearchQuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {

    private final QuestionJpaRepository questionJpaRepository;
    private final QuestionJpaQuerySupport questionJpaQuerySupport;

    @Override
    public Slice<Question> getQuestionsByExamId(Pageable pageable, QuestionStatement.Get get) {
        Slice<QuestionPayload.Get> questions =  questionJpaQuerySupport.getQuestionsByExamId(pageable, get);
        return questions.map(QuestionPayload.Get::toDomain);
    }

    @Override
    public Long getTotalCountByExamId(SearchQuestionDto.Search search, Long examId) {
        return questionJpaQuerySupport.getTotalCountByExamId(search, examId);
    }

    @Override
    public Question getQuestion(Long questionId) {
        QuestionPayload.GetWithSelections questionPayload =
                questionJpaQuerySupport.getQuestion(questionId);
        return questionPayload.toDomain();
    }

    @Override
    public Question save(Question question) {
        QuestionEntity save = questionJpaRepository.save(question.toEntity());
        return save.toDomain();
    }
}

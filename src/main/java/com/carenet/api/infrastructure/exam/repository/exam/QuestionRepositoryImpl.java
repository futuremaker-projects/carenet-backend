package com.carenet.api.infrastructure.exam.repository.exam;

import com.carenet.api.domain.exam.model.Question;
import com.carenet.api.domain.exam.repository.QuestionRepository;
import com.carenet.api.domain.exception.ApplicationException;
import com.carenet.api.domain.exception.ErrorCode;
import com.carenet.api.infrastructure.exam.dto.payload.QuestionPayload;
import com.carenet.api.infrastructure.exam.dto.statement.QuestionStatement;
import com.carenet.api.infrastructure.exam.entity.QuestionEntity;
import com.carenet.api.interfaces.exam.dto.SearchQuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
    public void updateArticle(Question question) {
        QuestionEntity questionEntity = questionJpaRepository.findById(question.getId()).orElseThrow(
                () -> new ApplicationException(ErrorCode.CONTENT_NOT_FOUND, "question not found : id - %d".formatted(question.getId())));
        questionEntity.updateArticle(question);
        // 도메인을 이용해서 update 하는 방법을 찾아야 함
        questionJpaRepository.save(questionEntity);
    }

    @Override
    public Question save(Question question) {
        QuestionEntity save = questionJpaRepository.save(question.toSave());
        return save.toDomain();
    }
}

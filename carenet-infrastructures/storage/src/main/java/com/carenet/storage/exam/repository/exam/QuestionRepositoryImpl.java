package com.carenet.storage.exam.repository.exam;

import com.carenet.common.exception.ApplicationException;
import com.carenet.common.exception.ErrorCode;
import com.carenet.exam.exam.dto.command.QuestionCommand;
import com.carenet.exam.exam.model.Question;
import com.carenet.exam.exam.repository.QuestionRepository;
import com.carenet.storage.exam.dto.exam.payload.QuestionPayload;
import com.carenet.storage.exam.dto.exam.statement.QuestionStatement;
import com.carenet.storage.exam.entity.exam.QuestionEntity;
import com.carenet.storage.exam.mapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {

    private final QuestionJpaRepository questionJpaRepository;
    private final QuestionJpaQuerySupport questionJpaQuerySupport;

    @Override
    public Slice<Question> getQuestionsByExamId(Pageable pageable, QuestionCommand.Get get) {
        QuestionStatement.Get getStatement = QuestionStatement.Get.of(get.examId());
        Slice<QuestionPayload.Get> questions =  questionJpaQuerySupport.getQuestionsByExamId(pageable, getStatement);
        return questions.map(QuestionPayload.Get::to);
    }

    @Override
    public List<Question> getQuestions(QuestionCommand.Get get) {
        QuestionStatement.Get getStatement = QuestionStatement.Get.of(get.examId());
        List<QuestionPayload.GetWithSelections> questions = questionJpaQuerySupport.getQuestionsByExamId(getStatement);
        return questions.stream().map(QuestionPayload.GetWithSelections::to).toList();
    }

    @Override
    public Long getTotalCountByExamId(QuestionCommand.Search search, Long examId) {
        QuestionStatement.Search searchStatement = QuestionStatement.Search.of();
        return questionJpaQuerySupport.getTotalCountByExamId(searchStatement, examId);
    }

    @Override
    public Question getQuestion(Long questionId) {
        QuestionPayload.GetWithSelections question = questionJpaQuerySupport.getQuestion(questionId);
        return question.to();
    }

    @Override
    public void updateArticle(QuestionCommand.Update create) {
        QuestionEntity questionEntity = questionJpaRepository.findById(create.id()).orElseThrow(
                () -> new ApplicationException(ErrorCode.CONTENT_NOT_FOUND, "question not found : id - %d".formatted(create.id())));
        questionEntity.updateArticle(create);
        // 도메인을 이용해서 update 하는 방법을 찾아야 함
        questionJpaRepository.save(questionEntity);
    }

    @Override
    public Question save(QuestionCommand.Create create) {
        QuestionEntity questionEntity = QuestionEntity.of(create.name(), create.examId(), create.article());
        QuestionEntity saved = questionJpaRepository.save(questionEntity);
        return ModelMapper.QuestionMapper.from(saved);
    }

}

package com.carenet.api.infrastructure.cbt.repository;

import com.carenet.api.domain.cbt.CbtRepository;
import com.carenet.api.domain.exam.model.Question;
import com.carenet.api.infrastructure.exam.dto.statement.QuestionStatement;
import com.carenet.api.infrastructure.exam.repository.QuestionJpaQuerySupport;
import com.carenet.api.infrastructure.exam.repository.QuestionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CbtRepositoryImpl implements CbtRepository {

    private final QuestionJpaRepository questionJpaRepository;
    private final QuestionJpaQuerySupport questionJpaQuerySupport;

    @Override
    public List<Question> getQuestionsByExamId(Long examId) {
        return questionJpaQuerySupport.getQuestionsByExamId(QuestionStatement.Get.of(examId))
                .stream().map(Question::from).toList();

    }

}

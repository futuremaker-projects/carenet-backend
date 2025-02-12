package com.carenet.storage.exam.repository.exam;

import com.carenet.exam.exam.dto.command.ExamCommand;
import com.carenet.exam.exam.model.Exam;
import com.carenet.exam.exam.repository.ExamRepository;
import com.carenet.storage.exam.dto.exam.payload.ExamPayload;
import com.carenet.storage.exam.dto.exam.statement.ExamStatement;
import com.carenet.storage.exam.entity.exam.ExamEntity;
import com.carenet.storage.exam.mapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ExamRepositoryImpl implements ExamRepository {

    private final ExamJpaRepository examJpaRepository;
    private final ExamJpaQuerySupport examJpaQuerySupport;

    @Override
    public Exam save(ExamCommand.Create exam) {
        ExamEntity savedEntity = examJpaRepository.save(ExamEntity.of(exam.name(), exam.orders()));
        return ModelMapper.ExamMapper.from(savedEntity);
    }

    @Override
    public Slice<Exam> getExams(Pageable pageable, ExamCommand.Search search) {
        ExamStatement.Search searchStatement = ExamStatement.Search.of(search.name());
        Slice<ExamPayload.Get> exams = examJpaQuerySupport.getExams(pageable, searchStatement);
        return exams.map(ExamPayload.Get::toDomain);
    }

    @Override
    public Long getTotalCount(ExamCommand.Search search) {
        ExamStatement.Search searchStatement = ExamStatement.Search.of(search.name());
        return examJpaQuerySupport.totalExamCount(searchStatement);
    }

}

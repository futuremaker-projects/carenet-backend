package com.carenet.api.infrastructure.exam.repository;

import com.carenet.api.domain.exam.model.Exam;
import com.carenet.api.domain.exam.repository.ExamRepository;
import com.carenet.api.infrastructure.exam.dto.payload.ExamPayload;
import com.carenet.api.interfaces.exam.dto.SearchExamDto;
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
    public Exam save(Exam exam) {
        return examJpaRepository.save(exam.to()).toDomain();
    }

    @Override
    public Slice<Exam> getExams(Pageable pageable, SearchExamDto.Search search) {
        Slice<ExamPayload.Get> exams = examJpaQuerySupport.getExams(pageable, search);
        return exams.map(ExamPayload.Get::toDomain);
    }

    @Override
    public Long getTotalCount(SearchExamDto.Search search) {
        return examJpaQuerySupport.totalExamCount(search);
    }

}

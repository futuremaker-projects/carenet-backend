package com.carenet.api.infrastructure.exam.repository.exam;

import com.carenet.api.domain.exam.model.Exam;
import com.carenet.api.domain.exam.repository.ExamRepository;
import com.carenet.api.infrastructure.exam.dto.ExamResult;
import com.carenet.api.interfaces.dto.SearchExamDto;
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
    public Slice<Exam> getExams(Pageable pageable, SearchExamDto.GetExams search) {
        Slice<ExamResult.Get> exams = examJpaQuerySupport.getExams(pageable, search);
        return exams.map(ExamResult.Get::toDomain);
    }

    @Override
    public Long totalExamCount(SearchExamDto.GetExams search) {
        return examJpaQuerySupport.totalExamCount(search);
    }

}

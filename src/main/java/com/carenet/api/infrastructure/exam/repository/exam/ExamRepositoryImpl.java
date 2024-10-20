package com.carenet.api.infrastructure.exam.repository.exam;

import com.carenet.api.domain.exam.model.Exam;
import com.carenet.api.domain.exam.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ExamRepositoryImpl implements ExamRepository {

    private final ExamJpaRepository examJpaRepository;

    @Override
    public Exam save(Exam exam) {
        return examJpaRepository.save(exam.to()).toDomain();
    }

}

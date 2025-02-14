package com.carenet.storage.exam.repository.cbt;

import com.carenet.exam.cbt.SubmissionRepository;
import com.carenet.exam.cbt.model.Submission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubmissionRepositoryImpl implements SubmissionRepository {

    private final SubmissionJpaRepository submissionJpaRepository;

    @Override
    public void saveSubmissions(List<Submission> submissions) {

    }

    @Override
    public void deleteSubmissions(Long examId, Long userId) {

    }
}

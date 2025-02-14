package com.carenet.exam.cbt;

import com.carenet.exam.cbt.model.Submission;

import java.util.List;

public interface SubmissionRepository {

    void saveSubmissions(List<Submission> submissions);

    void deleteSubmissions(Long examId, Long userId);

}

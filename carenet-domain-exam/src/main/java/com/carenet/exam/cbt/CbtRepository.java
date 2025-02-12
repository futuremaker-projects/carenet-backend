package com.carenet.exam.cbt;

import com.carenet.exam.cbt.model.Submission;

import java.util.List;

public interface CbtRepository {
    void deleteSubmissions(Long examId, Long userId);
    void saveSubmissions(List<Submission> submissions);
}

package com.carenet.api.domain.cbt;

import com.carenet.api.domain.cbt.model.Submission;

import java.util.List;

public interface CbtRepository {
    void deleteSubmissions(Long examId, Long userId);
    void saveSubmissions(List<Submission> submissions);
}

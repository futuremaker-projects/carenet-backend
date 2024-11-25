package com.carenet.api.domain.cbt;

import com.carenet.api.domain.exam.model.Question;

import java.util.List;

public interface CbtRepository {

    List<Question> getQuestionsByExamId(Long examId);

}

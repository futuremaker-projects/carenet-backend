package com.carenet.exam.cbt;

import com.carenet.exam.cbt.dto.command.CbtQuestionCommand;
import com.carenet.exam.cbt.model.CbtQuestion;

import java.util.List;

public interface CbtQuestionRepository {

    List<CbtQuestion> getCbtQuestions(CbtQuestionCommand.Get get);

}

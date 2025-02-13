package com.carenet.exam.exam.repository;

import com.carenet.exam.exam.dto.command.QuestionCommand;
import com.carenet.exam.exam.model.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface QuestionRepository {

    Slice<Question> getQuestionsByExamId(Pageable pageable, QuestionCommand.Get get);
    List<Question> getQuestions(QuestionCommand.Get get);

    Long getTotalCountByExamId(QuestionCommand.Search search, Long examId);

    Question getQuestion(Long questionId);

    Question save(QuestionCommand.Create create);

    void updateArticle(QuestionCommand.Update update);

}

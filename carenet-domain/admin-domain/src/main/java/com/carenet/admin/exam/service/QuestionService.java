package com.carenet.admin.exam.service;

import com.carenet.admin.exam.dto.command.QuestionCommand;
import com.carenet.admin.exam.dto.command.SelectionCommand;
import com.carenet.admin.exam.model.Question;
import com.carenet.admin.exam.repository.QuestionRepository;
import com.carenet.admin.exam.repository.SelectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.LongStream;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final SelectionRepository selectionRepository;

    public Slice<Question> getQuestionsByExamId(Pageable pageable, QuestionCommand.Get get) {
        return questionRepository.getQuestionsByExamId(pageable, get);
    }

    public List<Question> getQuestions(QuestionCommand.Get get) {
        return questionRepository.getQuestions(get);
    }

    /**
        문제 생성 - 5개의 객관식을 같이 생성
     */
    public void createQuestion(QuestionCommand.Create create) {
//        QuestionCommand.Create create = QuestionCommand.Create.of(question.getName(), question.getExamId(), question.getArticle());
        Question savedQuestion = questionRepository.save(create);

        LongStream.rangeClosed(1, 5).forEach(i -> {
            SelectionCommand.Create createSelection = SelectionCommand.Create.of(
                    savedQuestion.getId(), i, "%d번 객관식 답을 작성해주세요.".formatted(i)
            );
            selectionRepository.save(createSelection);
        });
    }

    public Long getTotalCountByExamId(QuestionCommand.Search search, Long examId) {
        return questionRepository.getTotalCountByExamId(search, examId);
    }

    public Question getQuestion(Long questionId) {
        return questionRepository.getQuestion(questionId);
    }

    @Transactional
    public void updateArticle(QuestionCommand.Update update) {
        questionRepository.updateArticle(update);
    }

}

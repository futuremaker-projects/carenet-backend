package com.carenet.api.domain.exam.service;

import com.carenet.api.domain.exam.dto.QuestionCommand;
import com.carenet.api.domain.exam.model.Selection;
import com.carenet.api.domain.exam.model.Question;
import com.carenet.api.domain.exam.repository.SelectionRepository;
import com.carenet.api.domain.exam.repository.QuestionRepository;
import com.carenet.api.interfaces.exam.dto.QuestionDto;
import com.carenet.api.interfaces.exam.dto.SearchQuestionDto;
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

    public Slice<QuestionDto.Response> getQuestionsByExamId(Pageable pageable, QuestionCommand.Get get) {
        return questionRepository.getQuestionsByExamId(pageable, get.toStatement())
                .map(QuestionDto.Response::fromWithoutSelections);
    }

    /**
        문제 생성 - 5개의 객관식을 같이 생성
     */
    public void createQuestion(Question question) {
        Question savedQuestion = questionRepository.save(question);

        LongStream.rangeClosed(1, 5).forEach(i -> {
            Selection selection = Selection.of(
                    savedQuestion.getId(), i,
                    "%d번 객관식 답을 작성해주세요.".formatted(i)
            );
            selectionRepository.save(selection);
        });
    }

    public Long getTotalCountByExamId(SearchQuestionDto.Search search, Long examId) {
        return questionRepository.getTotalCountByExamId(search, examId);
    }

    public QuestionDto.Response getQuestion(Long questionId) {
        Question question = questionRepository.getQuestion(questionId);
        return QuestionDto.Response.from(question);
    }

    @Transactional
    public void updateArticle(Question update) {
        questionRepository.updateArticle(update);
    }

    public List<QuestionDto.Response> getQuestions(QuestionCommand.Get command) {
        List<Question> questions = questionRepository.getQuestions(command.toStatement());
        return questions.stream().map(QuestionDto.Response::from).toList();
    }
}

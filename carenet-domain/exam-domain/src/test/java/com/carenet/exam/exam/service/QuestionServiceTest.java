package com.carenet.exam.exam.service;

import com.carenet.exam.exam.dto.command.QuestionCommand;
import com.carenet.exam.exam.model.Question;
import com.carenet.exam.exam.repository.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {

    @InjectMocks
    private QuestionService sut;

    @Mock
    private QuestionRepository questionRepository;

    @DisplayName("문제 id와 문제 본문으로 기존의 문제의 본문을 수정한다.")
    @Test
    void givenQuestionIdAndArticle_whenRequestingUpdateArticle_thenReturnNothing() {
        // given
        Long questionId = 1L;
        String article = "article";
        Question question = Question.of(questionId, article);
        QuestionCommand.Update update = QuestionCommand.Update.of(questionId, article);

        given(questionRepository.getQuestion(questionId)).willReturn(question);

        // when
        sut.updateArticle(update);

        // then
        Question findQuestion = questionRepository.getQuestion(questionId);
        assertThat(findQuestion.getArticle()).isEqualTo(article);
    }

}
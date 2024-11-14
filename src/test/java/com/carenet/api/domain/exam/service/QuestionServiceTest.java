package com.carenet.api.domain.exam.service;

import com.carenet.api.domain.exam.model.Question;
import com.carenet.api.domain.exam.repository.QuestionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

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

        given(questionRepository.getQuestion(questionId)).willReturn(question);

        // when
        sut.updateArticle(question);

        // then
        Question findQuestion = questionRepository.getQuestion(questionId);
        assertThat(findQuestion.getArticle()).isEqualTo(article);
    }

}
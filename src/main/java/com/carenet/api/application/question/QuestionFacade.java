package com.carenet.api.application.question;

import com.carenet.api.domain.exam.service.OptionService;
import com.carenet.api.domain.exam.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionFacade {

    private final QuestionService questionService;
    private final OptionService optionService;

    private void createQuestion(QuestionCriteria.Create create) {
        // 문제 생성은 도메인에서 해도 충분하다.
        // 하위 객관식 문제는 같은 exam의 하위 에크리거트에 있다.
    }

}

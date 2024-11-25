package com.carenet.api.interfaces.cbt;

import com.carenet.api.domain.exam.dto.QuestionCommand;
import com.carenet.api.domain.exam.service.QuestionService;
import com.carenet.api.interfaces.exam.dto.QuestionDto;
import com.carenet.api.support.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cbt")
@RequiredArgsConstructor
public class CbtController {

    private final QuestionService questionService;

    @GetMapping("/exams/{examId}/questions")
    public Response<List<QuestionDto.Response>> getQuestions(@PathVariable("examId") Long examId) {
        List<QuestionDto.Response> questions = questionService.getQuestions(QuestionCommand.Get.of(examId));
        return Response.success(questions);
    }

}

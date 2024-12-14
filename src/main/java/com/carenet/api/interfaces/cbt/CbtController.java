package com.carenet.api.interfaces.cbt;

import com.carenet.api.domain.cbt.CbtService;
import com.carenet.api.domain.exam.dto.QuestionCommand;
import com.carenet.api.domain.exam.service.QuestionService;
import com.carenet.api.interfaces.cbt.dto.CbtDto;
import com.carenet.api.interfaces.exam.dto.QuestionDto;
import com.carenet.api.support.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cbt")
@RequiredArgsConstructor
public class CbtController {

    private final QuestionService questionService;
    private final CbtService cbtService;

    @GetMapping("/exams/{examId}/questions")
    public Response<List<QuestionDto.Response>> getQuestions(@PathVariable("examId") Long examId) {
        List<QuestionDto.Response> questions = questionService.getQuestions(QuestionCommand.Get.of(examId));
        return Response.success(questions);
    }

    @PostMapping("/exams/submit")
    public Response<Void> submitAnswers(@RequestBody CbtDto.Request request) {
        Long userId = 1L;
        cbtService.saveCbtSubmissions(request.toCommand(), userId);
        return Response.success();
    }

}

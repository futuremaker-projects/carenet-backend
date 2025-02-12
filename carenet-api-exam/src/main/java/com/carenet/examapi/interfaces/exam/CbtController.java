package com.carenet.examapi.interfaces.exam;

import com.carenet.common.response.Response;
import com.carenet.exam.cbt.CbtService;
import com.carenet.exam.exam.dto.command.QuestionCommand;
import com.carenet.exam.exam.service.QuestionService;
import com.carenet.examapi.interfaces.dto.CbtDto;
import com.carenet.examapi.interfaces.dto.QuestionDto;
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
        List<QuestionDto.Response> questions = questionService.getQuestions(QuestionCommand.Get.of(examId))
                .stream().map(QuestionDto.Response::from)
                .toList();
        return Response.success(questions);
    }

    @PostMapping("/exams/submit")
    public Response<Void> submitAnswers(@RequestBody CbtDto.Request request) {
        Long userId = 1L;
        cbtService.saveCbtSubmissions(request.toCommand(), userId);
        return Response.success();
    }

}

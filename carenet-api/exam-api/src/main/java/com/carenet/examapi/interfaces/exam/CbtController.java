package com.carenet.examapi.interfaces.exam;

import com.carenet.common.response.Response;
import com.carenet.exam.cbt.CbtQuestionService;
import com.carenet.exam.cbt.CbtService;
import com.carenet.exam.cbt.dto.command.CbtQuestionCommand;
import com.carenet.examapi.interfaces.dto.CbtDto;
import com.carenet.examapi.interfaces.dto.CbtQuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exam/cbt")
@RequiredArgsConstructor
public class CbtController {

    private final CbtService cbtService;
    private final CbtQuestionService cbtQuestionService;

    @GetMapping("/exams/{examId}/questions")
    public Response<List<CbtQuestionDto.Response>> getQuestions(@PathVariable("examId") Long examId) {
        List<CbtQuestionDto.Response> questions = cbtQuestionService.getCbtQuestions(CbtQuestionCommand.Get.of(examId))
                .stream().map(CbtQuestionDto.Response::from)
                .toList();
        return Response.success(questions);
    }

    @PostMapping("/exams/submit")
    public Response<Void> submitAnswers(@RequestBody CbtDto.Submit submit) {
        Long userId = 1L;
        cbtService.saveCbtSubmissions(submit.toCommand(), userId);
        return Response.success();
    }

}

package com.carenet.api.interfaces.controller;

import com.carenet.api.domain.exam.service.ExamService;
import com.carenet.api.interfaces.dto.ExamDto;
import com.carenet.api.interfaces.dto.SearchDto;
import com.carenet.api.support.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @PostMapping
    public Response<List<ExamDto.Response>> getList(@RequestBody SearchDto.Exam searchExam) {
        return Response.success(List.of());
    }

    @PostMapping("/save")
    public Response<Void> saveExam(@RequestBody ExamDto.Request requestDto) {
        examService.saveExam(requestDto);
        return Response.success();
    }

}

package com.carenet.api.interfaces.controller;

import com.carenet.api.domain.exam.model.Exam;
import com.carenet.api.domain.exam.service.ExamService;
import com.carenet.api.domain.useraccount.UserAccount;
import com.carenet.api.interfaces.dto.ExamDto;
import com.carenet.api.interfaces.dto.SearchExamDto;
import com.carenet.api.support.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exams")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @PostMapping
    public Response<Slice<ExamDto.Response>> getList(Pageable pageable, @RequestBody SearchExamDto.GetExams search) {
        Slice<ExamDto.Response> exams = examService.getExams(pageable, search);
        return Response.success(exams);
    }

    @PostMapping("/total")
    public Response<Long> getTotal(@RequestBody SearchExamDto.GetExams search) {
        Long count = examService.getTotalExamsCount(search);
        return Response.success(count);
    }

    @PostMapping("/save")
    public Response<Void> saveExam(@RequestBody ExamDto.Request requestDto) {
        examService.saveExam(requestDto);
        return Response.success();
    }

}

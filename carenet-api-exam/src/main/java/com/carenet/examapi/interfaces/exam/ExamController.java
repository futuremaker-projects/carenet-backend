package com.carenet.examapi.interfaces.exam;

import com.carenet.common.response.Response;
import com.carenet.exam.exam.dto.command.QuestionCommand;
import com.carenet.exam.exam.service.ExamService;
import com.carenet.exam.exam.service.QuestionService;
import com.carenet.examapi.interfaces.dto.ExamDto;
import com.carenet.examapi.interfaces.dto.SearchExamDto;
import com.carenet.examapi.interfaces.dto.QuestionDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "모의고사 Api", description = "모의고사 회차")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "성공", content = {@Content(schema = @Schema(implementation = ExamDto.Response.class))}),
        @ApiResponse(responseCode = "200", description = "모의고사 등록 실패"),
})
@RestController
@RequestMapping("/api/exams")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;
    private final QuestionService questionService;

    @Operation(summary = "모의고사 목록조회 - slice")
    @Parameter(name = "모의고사 회차 목록조회", description = "pageable 및 조회용 search 객체")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(examples = {
            @ExampleObject(name = "Slice", value =
                    """
                        { "name": null }
                    """
            )}))
    @PostMapping
    public Response<Slice<ExamDto.Response>> getExams(Pageable pageable, @RequestBody SearchExamDto.Search search) {
        Slice<ExamDto.Response> exams = examService.getExams(pageable, search.toCommand()).map(ExamDto.Response::from);
        return Response.success(exams);
    }

    @Operation(summary = "모의고사 전체수량 - 목록의 인덱스를 위한")
    @Parameter(name = "모의고사 전체수량", description = "모의고사 명으로 조회")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(examples = {
            @ExampleObject(name = "Long", value =
                    """
                        { "size": 15, "page": 0, "sort": "createdAt,desc", "last": false }
                    """
            )}))
    @PostMapping("/total")
    public Response<Long> getTotal(@RequestBody ExamDto.Search search) {
        Long count = examService.getTotalExamsCount(search.toCommand());
        return Response.success(count);
    }

    @Operation(summary = "")
    @Parameter(name = "모의고사 회차 등록", description = "모의고사 명을 이용하여 등록")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(examples = {
            @ExampleObject(name = "ExamDto.Request", value =
                    """
                        {"name" : "모의고사 1회"}
                    """
            )}))
    @PostMapping("/save")
    public Response<Void> saveExam(@RequestBody ExamDto.Request requestDto) {
        examService.createExam(requestDto.toCommand());
        return Response.success();
    }

    @Operation(summary = "문제 목록 조회")
    @Parameter(name = "문제 목록 조회", description = "문제 목록페이지")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(examples = {
            @ExampleObject(name = "QuestionDto.Response", value =
                    """
                        { "size": 15, "page": 0, "sort": "createdAt,desc", "last": false }
                    """
            )}))
    @PostMapping("/{examId}/questions")
    public Response<Slice<QuestionDto.Response>> getQuestionsByExamId(Pageable pageable, @PathVariable("examId") Long examId) {
        Slice<QuestionDto.Response> questions =
                questionService.getQuestionsByExamId(pageable, QuestionCommand.Get.of(examId)).map(QuestionDto.Response::from);
        return Response.success(questions);
    }

}

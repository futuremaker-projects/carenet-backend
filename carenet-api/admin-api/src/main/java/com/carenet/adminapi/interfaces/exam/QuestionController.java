package com.carenet.adminapi.interfaces.exam;

import com.carenet.admin.exam.service.QuestionService;
import com.carenet.adminapi.interfaces.dto.ExamDto;
import com.carenet.adminapi.interfaces.dto.QuestionDto;
import com.carenet.common.response.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "문제 Api", description = "모의고사 문제")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "성공", content = {@Content(schema = @Schema(implementation = ExamDto.Response.class))}),
        @ApiResponse(responseCode = "200", description = "문제 등록 실패"),
})
@RestController
@RequestMapping("/api/admin/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @Operation(summary = "문제 생성")
    @Parameter(name = "문제 생성", description = "문제 명을 이용한 문제생성")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(examples = {
            @ExampleObject(name = "question", value =
                    """
                        { "name": "문제1" }
                    """
            )}))
    @PostMapping("/save")
    public Response<Void> createQuestion(@RequestBody QuestionDto.Create createDto) {
        questionService.createQuestion(createDto.toCreateCommand());
        return Response.success();
    }

    @Operation(summary = "문제 단일 조회")
    @Parameter(name = "문제 단일 조회", description = "문제 상세페이지")
    @GetMapping("/{questionId}")
    public Response<QuestionDto.Response> getQuestionByExamId(@PathVariable("questionId") Long questionId) {
        QuestionDto.Response question = QuestionDto.Response.from(questionService.getQuestion(questionId));
        return Response.success(question);
    }

    @PutMapping
    public Response<Void> updateArticle(@RequestBody QuestionDto.Update updateDto) {
        questionService.updateArticle(updateDto.toUpdateCommand());
        return Response.success();
    }

}

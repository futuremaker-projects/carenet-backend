package com.carenet.examapi.interfaces.dto;

import com.carenet.exam.cbt.model.CbtQuestion;

import java.util.Collections;
import java.util.List;

public class CbtQuestionDto {

    public record Response(Long id, Long examId, Long codeId,
                           String name, String article, List<CbtSelectionDto.Response> selections) {

        public static Response of(Long id, Long examId, Long codeId, String name, String article) {
            return new Response(id, examId, codeId, name, article, null);
        }

        public static Response of(Long id, Long examId, Long codeId, String name,
                                  String article, List<CbtSelectionDto.Response> selections) {
            return new Response(id, examId, codeId, name, article, selections);
        }

        public static Response fromWithoutSelections(CbtQuestion cbtQuestion) {
            return Response.of(
                    cbtQuestion.getId(), cbtQuestion.getExamId(), cbtQuestion.getCodeId(),
                    cbtQuestion.getName(), cbtQuestion.getArticle(), null
            );
        }

        public static Response from(CbtQuestion cbtQuestion) {
            return Response.of(
                    cbtQuestion.getId(), cbtQuestion.getExamId(), cbtQuestion.getCodeId(),
                    cbtQuestion.getName(), cbtQuestion.getArticle(),
                    cbtQuestion.getSelections() != null ?
                            cbtQuestion.getSelections().stream().map(CbtSelectionDto.Response::from).toList() :
                            Collections.emptyList()
            );
        }
    }

}

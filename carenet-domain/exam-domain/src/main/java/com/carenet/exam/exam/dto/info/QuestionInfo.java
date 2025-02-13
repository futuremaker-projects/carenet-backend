package com.carenet.exam.exam.dto.info;

import com.carenet.exam.exam.model.Question;

import java.util.List;

public class QuestionInfo {

    public record Response(Long id, Long examId, Long codeId,
                           String name, String article,
                           List<SelectionInfo.Response> selections) {
        public static Response of(Long id, Long examId, Long codeId,
                                  String name, String article,
                                  List<SelectionInfo.Response> selections) {
            return new Response(id, examId, codeId, name, article, selections);
        }

        public static Response fromWithoutSelections(Question question) {
            return Response.of(
                    question.getId(), question.getExamId(), question.getCodeId(),
                    question.getName(), question.getArticle(), null
            );
        }

        public static Response from(Question question) {
            return Response.of(
                    question.getId(), question.getExamId(), question.getCodeId(),
                    question.getName(), question.getArticle(),
                    question.getSelections().stream().map(SelectionInfo.Response::from).toList()
            );
        }
    }

}

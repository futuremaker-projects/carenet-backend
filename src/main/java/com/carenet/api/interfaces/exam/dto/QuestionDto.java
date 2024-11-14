package com.carenet.api.interfaces.exam.dto;

import com.carenet.api.domain.exam.dto.QuestionCommand;
import com.carenet.api.domain.exam.model.Question;

import java.util.List;

public class QuestionDto {

    public record Request(Long id, String name, Long examId, String article) {
        public Request of(String name, Long examId, String article) {
            return new Request(null, name, examId, article);
        }

        public Question toDomain() {
            return Question.of(name, examId, article);
        }

        public Question toUpdate() {
            return Question.of(id, article);
        }

        public QuestionCommand.Get toCommand() {
            return QuestionCommand.Get.of(id);
        }
    }

    public record Response(Long id, Long examId, Long codeId,
                           String name, String article, List<SelectionDto.Response> selections) {

        public static Response of(Long id, Long examId, Long codeId, String name, String article) {
            return new Response(id, examId, codeId, name, article, null);
        }

        public static Response of(Long id, Long examId, Long codeId, String name, String article, List<SelectionDto.Response> selections) {
            return new Response(id, examId, codeId, name, article, selections);
        }

        public static Response fromDomainList(Question question) {
            return Response.of(
                    question.getId(), question.getExamId(), question.getCodeId(),
                    question.getName(), question.getArticle(), null
            );
        }

        public static Response fromDomain(Question question) {
            return Response.of(
                    question.getId(), question.getExamId(), question.getCodeId(),
                    question.getName(), question.getArticle(),
                    question.getSelections().stream().map(SelectionDto.Response::from).toList()
            );
        }
    }

    public record Search() {

    }
}

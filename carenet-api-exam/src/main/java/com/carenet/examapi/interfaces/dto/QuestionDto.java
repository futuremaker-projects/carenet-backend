package com.carenet.examapi.interfaces.dto;


import com.carenet.exam.exam.dto.command.QuestionCommand;
import com.carenet.exam.exam.model.Question;

import java.util.List;
import java.util.Stack;

public class QuestionDto {
    public record Create(String name, Long examId, String article) {
        public static Create of(String name, Long examId, String article) {
            return new Create(name, examId, article);
        }

        public QuestionCommand.Create toCreateCommand() {
            return QuestionCommand.Create.of(name, examId, article);
        }
    }

    public record Update(Long id, String article) {
        public static Update of(Long id, String article) {
            return new Update(id, article);
        }

        public QuestionCommand.Update toUpdateCommand() {
            return QuestionCommand.Update.of(id, article);
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

//        public static Response fromWithoutSelections(Question question) {
//            return Response.of(
//                    question.getId(), question.getExamId(), question.getCodeId(),
//                    question.getName(), question.getArticle(), null
//            );
//        }

        public static Response from(Question question) {
            return Response.of(
                    question.getId(), question.getExamId(), question.getCodeId(),
                    question.getName(), question.getArticle(),
                    question.getSelections().stream().map(SelectionDto.Response::from).toList()
            );
        }
    }

    public record Search(String name) {
        public static Search of(String name) {
            return new Search(name);
        }

        public QuestionCommand.Search toCommand() {
            return QuestionCommand.Search.of(name);
        }
    }
}

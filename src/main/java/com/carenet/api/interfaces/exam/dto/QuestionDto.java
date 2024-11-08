package com.carenet.api.interfaces.exam.dto;

import com.carenet.api.domain.exam.dto.QuestionCommand;
import com.carenet.api.domain.exam.model.Question;
import com.carenet.api.domain.exam.model.Selection;

import java.util.List;

public class QuestionDto {

    public record Request(Long id, String name, Long examId) {
        public Request of(String name, Long examId) {
            return new Request(null, name, examId);
        }

        public Question toDomain() {
            return Question.of(name, examId);
        }

        public QuestionCommand.Get toCommand() {
            return QuestionCommand.Get.of(id);
        }
    }

    public record Response(Long id, Long examId, Long codeId,
                           String name, String article, List<Selection> selections) {

        public static Response of(Long id, Long examId, Long codeId, String name, String article) {
            return new Response(id, examId, codeId, name, article, null);
        }

        public static Response from(Question question) {
            return Response.of(
                    question.getId(), question.getExamId(), question.getCodeId(),
                    question.getName(), question.getArticle()
            );
        }
    }

    public record Search() {

    }
}

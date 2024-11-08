package com.carenet.api.domain.exam.dto;

import com.carenet.api.infrastructure.exam.dto.statement.QuestionStatement;

public class QuestionCommand {

    public record Get(Long examId) {
        public static Get of(Long examId) {
            return new Get(examId);
        }

        public QuestionStatement.Get toStatement() {
            return QuestionStatement.Get.of(this.examId);
        }
    }

}

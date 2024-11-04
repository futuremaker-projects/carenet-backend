package com.carenet.api.infrastructure.exam.dto.statement;

public class QuestionStatement {

    public record Get(Long examId) {
        public static Get of(Long examId) {
            return new Get(examId);
        }
    }

}

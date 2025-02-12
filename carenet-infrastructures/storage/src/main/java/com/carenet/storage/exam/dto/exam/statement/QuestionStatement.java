package com.carenet.storage.exam.dto.exam.statement;

public class QuestionStatement {

    public record Get(Long examId) {
        public static Get of(Long examId) {
            return new Get(examId);
        }
    }

    public record Search() {
        public static Search of() {
            return new Search();
        }
    }
}

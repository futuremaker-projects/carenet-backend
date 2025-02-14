package com.carenet.exam.cbt.dto.command;

public class CbtQuestionCommand {

    public record Get(Long examId) {
        public static Get of(Long examId) {
            return new Get(examId);
        }
    }

}

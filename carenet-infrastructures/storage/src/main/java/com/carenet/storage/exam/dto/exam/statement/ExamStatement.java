package com.carenet.storage.exam.dto.exam.statement;

public class ExamStatement {

    public record Search(String name) {
        public static Search of(String name) {
            return new Search(name);
        }
    }

}

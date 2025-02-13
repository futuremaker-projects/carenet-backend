package com.carenet.exam.exam.dto.command;

public class QuestionCommand {
    public record Get(Long examId) {
        public static Get of(Long examId) {
            return new Get(examId);
        }

//        public QuestionStatement.Get toStatement() {
//            return QuestionStatement.Get.of(this.examId);
//        }
    }

    public record Search(String name) {
        public static Search of(String name) {
            return new Search(name);
        }
    }

    public record Update(Long id, String article) {
        public static Update of(Long id, String article) {
            return new Update(id, article);
        }
    }

    public record Create(String name, Long examId, String article) {
        public static Create of(String name, Long examId, String article) {
            return new Create(name, examId, article);
        }
    }
}

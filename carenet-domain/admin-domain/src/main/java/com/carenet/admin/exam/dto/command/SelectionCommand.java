package com.carenet.admin.exam.dto.command;

public class SelectionCommand {

    public record Get(Long questionId, Long selectionId) {
        public static Get of(Long questionId, Long selectionId) {
            return new Get(questionId, selectionId);
        }
    }

    public record Create(Long questionId, Long selectionId, String content) {
        public static Create of(Long questionId, Long selectionId, String content) {
            return new Create(questionId, selectionId, content);
        }
    }

    public record Update(Long questionId, Long selectionId, String content) {
        public static Update of(Long questionId, Long selectionId, String content) {
            return new Update(questionId, selectionId, content);
        }
    }

}

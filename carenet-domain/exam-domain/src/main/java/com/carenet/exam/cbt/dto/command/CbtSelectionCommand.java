package com.carenet.exam.cbt.dto.command;

public class CbtSelectionCommand {

    public record Update(Long questionId, Long selectionId, String content) {
        public static Update of(Long questionId, Long selectionId, String content) {
            return new Update(questionId, selectionId, content);
        }
    }

}

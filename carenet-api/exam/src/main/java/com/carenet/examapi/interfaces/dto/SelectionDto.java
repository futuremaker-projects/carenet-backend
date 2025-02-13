package com.carenet.examapi.interfaces.dto;

import com.carenet.exam.exam.dto.command.SelectionCommand;
import com.carenet.exam.exam.model.Selection;

import java.time.LocalDateTime;

public class SelectionDto {

    public record Response(Long questionId,
            Long selectionId,
            String content,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {

        public static Response of(Long questionId, Long selectionId, String content,
                           LocalDateTime createdAt, LocalDateTime updatedAt) {
            return new Response(questionId, selectionId, content, createdAt, updatedAt);
        }

        public static Response from(Selection selection) {
            return Response.of(
                    selection.getQuestionId(), selection.getSelectionId(), selection.getContent(),
                    selection.getCreatedAt(), selection.getUpdatedAt()
            );
        }

    }

    public record RequestUpdate(Long questionId, Long selectionId, String content) {
        public static RequestUpdate of(Long questionId, Long selectionId, String content) {
            return new RequestUpdate(questionId, selectionId, content);
        }

        public SelectionCommand.Update toCommand() {
            return SelectionCommand.Update.of(questionId, selectionId, content);
        }
    }

}

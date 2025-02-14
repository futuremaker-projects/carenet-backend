package com.carenet.adminapi.interfaces.dto;


import com.carenet.admin.exam.dto.command.SelectionCommand;
import com.carenet.admin.exam.model.Selection;

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

    public record Update(Long questionId, Long selectionId, String content) {
        public static Update of(Long questionId, Long selectionId, String content) {
            return new Update(questionId, selectionId, content);
        }

        public SelectionCommand.Update toCommand() {
            return SelectionCommand.Update.of(questionId, selectionId, content);
        }
    }

}

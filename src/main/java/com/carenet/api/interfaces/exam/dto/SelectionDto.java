package com.carenet.api.interfaces.exam.dto;

import com.carenet.api.domain.exam.model.Selection;

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

    public record Request(Long questionId, Long selectionId, String content) {
        public static Request of(Long questionId, Long selectionId, String content) {
            return new Request(questionId, selectionId, content);
        }

        public Selection toDomain() {
            return Selection.of(questionId, selectionId, content);
        }
    }

}

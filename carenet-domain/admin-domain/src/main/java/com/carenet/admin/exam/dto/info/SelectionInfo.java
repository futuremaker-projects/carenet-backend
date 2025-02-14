package com.carenet.admin.exam.dto.info;

import com.carenet.admin.exam.model.Selection;

import java.time.LocalDateTime;

public class SelectionInfo {

    public record Response(Long questionId,
                           Long selectionId,
                           String content,
                           LocalDateTime createdAt,
                           LocalDateTime updatedAt) {

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

}

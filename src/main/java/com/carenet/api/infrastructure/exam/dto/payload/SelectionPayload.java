package com.carenet.api.infrastructure.exam.dto.payload;

import com.carenet.api.domain.exam.model.Selection;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class SelectionPayload {
    @Getter
    @NoArgsConstructor
    public static class Get {

        private Long questionId;
        private Long selectionId;
        private String content;
        private LocalDateTime updatedAt;
        private LocalDateTime createdAt;

        @QueryProjection
        public Get(Long questionId, Long selectionId, String content, LocalDateTime updatedAt, LocalDateTime createdAt) {
            this.questionId = questionId;
            this.selectionId = selectionId;
            this.content = content;
            this.updatedAt = updatedAt;
            this.createdAt = createdAt;
        }

        public Selection toDomain() {
            return Selection.of(questionId, selectionId, content);
        }
    }
}

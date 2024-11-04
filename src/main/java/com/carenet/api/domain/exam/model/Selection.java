package com.carenet.api.domain.exam.model;

import com.carenet.api.infrastructure.exam.entity.SelectionEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
    객관식 문제 - 문제의 하위 객관식을 의미함
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Selection {

    private Long questionId;
    private Long selectionId;
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Selection(Long questionId, Long selectionId, String content) {
        this.questionId = questionId;
        this.selectionId = selectionId;
        this.content = content;
    }

    public static Selection of(Long questionId, Long userId, String content) {
        return new Selection(questionId, userId, content);
    }

    public static Selection of(Long questionId, Long userId) {
        return new Selection(questionId, userId, null);
    }

    public SelectionEntity toEntity() {
        return SelectionEntity.of(questionId, selectionId);
    }
}

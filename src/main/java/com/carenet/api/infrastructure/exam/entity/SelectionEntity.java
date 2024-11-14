package com.carenet.api.infrastructure.exam.entity;

import com.carenet.api.domain.exam.model.Selection;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "selection")
public class SelectionEntity {

    @EmbeddedId
    private SelectionComplexIds id;

    @Column(columnDefinition = "text comment '본문'")
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    private void createdAt() {
        createdAt = LocalDateTime.now();
    }

    public SelectionEntity(SelectionComplexIds id, String content) {
        this.id = id;
        this.content = content;
    }

    public static SelectionEntity of(Long questionId, Long optionId, String content) {
        return new SelectionEntity(SelectionComplexIds.of(questionId, optionId), content);
    }

    public Selection toDomain() {
        return Selection.of(id.getQuestionId(), id.getSelectionId(), content);
    }

}

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

    public SelectionEntity(SelectionComplexIds id) {
        this.id = id;
    }

    public static SelectionEntity of(Long questionId, Long optionId) {
        return new SelectionEntity(SelectionComplexIds.of(questionId, optionId));
    }

    public Selection toDomain() {
        return Selection.of(id.getQuestionId(), id.getSelectionId(), content);
    }

}

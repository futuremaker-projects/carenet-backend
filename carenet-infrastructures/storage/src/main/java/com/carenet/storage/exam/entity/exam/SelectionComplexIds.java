package com.carenet.storage.exam.entity.exam;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SelectionComplexIds implements Serializable {

    @Column(name = "question_id")
    private Long questionId;
    @Column(name = "selection_id")
    private Long selectionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof SelectionComplexIds ids)) return false;
        return Objects.equals(questionId, ids.questionId) && Objects.equals(selectionId, ids.selectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, selectionId);
    }

    public static SelectionComplexIds of(Long questionId, Long selectionId) {
        return SelectionComplexIds.builder().questionId(questionId).selectionId(selectionId).build();
    }
}

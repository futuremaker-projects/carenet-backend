package com.carenet.api.infrastructure.exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionHistoryComplexIds {

    @Column(name = "question_id")
    private Long questionId;
    @Column(name = "user_id")
    private Long userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof SubmissionHistoryComplexIds ids)) return false;
        return Objects.equals(questionId, ids.questionId) && Objects.equals(userId, ids.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, userId);
    }

}

package com.carenet.storage.exam.entity.cbt;

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
public class SubmissionComplexIds {
    @Column(name = "exam_id")
    private Long examId;
    @Column(name = "question_id")
    private Long questionId;
    @Column(name = "user_id")
    private Long userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof SubmissionComplexIds ids)) return false;
        return Objects.equals(examId, ids.examId)
                && Objects.equals(questionId, ids.questionId)
                && Objects.equals(userId, ids.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examId, questionId, userId);
    }
}

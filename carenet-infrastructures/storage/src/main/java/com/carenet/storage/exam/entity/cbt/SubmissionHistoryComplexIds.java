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
public class SubmissionHistoryComplexIds {

    @Column(name = "exam_id")
    private Long examId;            // 특정 모의고사의
    @Column(name = "question_id")
    private Long questionId;        // 특정 문제의 답을 저장함
    @Column(name = "user_id")
    private Long userId;            // 사용자 별로

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

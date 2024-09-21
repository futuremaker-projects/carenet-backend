package com.carenet.api.infrastructure.exam.entity;

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
public class OptionsComplexIds implements Serializable {

    @Column(name = "question_id")
    private Long questionId;
    @Column(name = "option_id")
    private Long optionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof OptionsComplexIds ids)) return false;
        return Objects.equals(questionId, ids.questionId) && Objects.equals(optionId, ids.optionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, optionId);
    }


}

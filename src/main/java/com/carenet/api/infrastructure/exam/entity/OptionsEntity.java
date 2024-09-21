package com.carenet.api.infrastructure.exam.entity;

import com.carenet.api.domain.exam.model.Options;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "options")
public class OptionsEntity {

    @EmbeddedId
    private OptionsComplexIds id;

    private String content;

    public Options toDomain() {
        return Options.of(id.getQuestionId(), id.getOptionId(), content);
    }

}

package com.carenet.api.infrastructure.exam.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "submission")
public class SubmissionEntity {

    @EmbeddedId
    private SubmissionComplexIds id;

    private Integer choice;

    private Boolean correct;

}

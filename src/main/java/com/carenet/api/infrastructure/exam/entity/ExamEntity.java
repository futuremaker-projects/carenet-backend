package com.carenet.api.infrastructure.exam.entity;

import com.carenet.api.domain.exam.model.Exam;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "exam")
public class ExamEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    public Exam toDomain() {
        return Exam.of(id, title);
    }

}

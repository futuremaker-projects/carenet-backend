package com.carenet.api.infrastructure.exam.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "question")
public class QuestionEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long examId;
    private Long codeId;

    @Column(columnDefinition = "text comment '문제 본문'")
    private String article;

    private Integer answer;

}

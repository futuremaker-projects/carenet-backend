package com.carenet.api.infrastructure.exam.entity;

import com.carenet.api.domain.exam.model.Question;
import com.carenet.api.domain.exam.model.enums.ProgressType;
import com.carenet.api.infrastructure.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "question")
public class QuestionEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long examId;
    private Long codeId;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(50) default 'IN_PROGRESS' comment '진행상황'")
    private ProgressType progressType;

    @Column(columnDefinition = "text comment '문제 본문'")
    private String article;

    private Integer answer;

    public QuestionEntity(String name, Long examId) {
        this.name = name;
        this.examId = examId;
    }

    public static QuestionEntity of(String name, Long examId) {
        return new QuestionEntity(name, examId);
    }

    public Question toDomain() {
        return new Question(
                this.id, this.name, this.codeId,
                this.examId, this.article, this.answer
        );
    }
}

package com.carenet.api.infrastructure.exam.entity;

import com.carenet.api.domain.exam.model.Question;
import com.carenet.api.domain.exam.model.enums.ProgressType;
import com.carenet.api.infrastructure.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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

    public QuestionEntity(String name, Long examId, String article) {
        this.name = name;
        this.examId = examId;
        this.article = article;
    }

    @Builder
    public QuestionEntity(Long id, Long examId, Long codeId, String name, ProgressType progressType, String article, Integer answer) {
        this.id = id;
        this.examId = examId;
        this.codeId = codeId;
        this.name = name;
        this.progressType = progressType;
        this.article = article;
        this.answer = answer;
    }

    public static QuestionEntity of(String name, Long examId, String article) {
        return new QuestionEntity(name, examId, article);
    }

    public static QuestionEntity of(Long id, String article) {
        return QuestionEntity.builder()
                .id(id)
                .article(article)
                .build();
    }

    public Question toDomain() {
        return new Question(
                this.id, this.name, this.codeId,
                this.examId, this.article, this.answer
        );
    }

    public void updateArticle(Question question) {
        this.article = question.getArticle();
    }
}

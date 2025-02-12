package com.carenet.storage.exam.entity.exam;

import com.carenet.common.enums.ProgressType;
import com.carenet.exam.exam.dto.command.QuestionCommand;
import com.carenet.storage.BaseEntity;
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
    @Column(columnDefinition = "varchar(50) default 'IN_PROGRESS' comment '진행상태'")
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

    public void updateArticle(QuestionCommand.Update update) {
        this.article = update.article();
    }
}

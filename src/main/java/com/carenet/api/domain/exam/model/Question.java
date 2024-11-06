package com.carenet.api.domain.exam.model;

import com.carenet.api.domain.useraccount.UserAccount;
import com.carenet.api.infrastructure.exam.entity.QuestionEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/*
    문제
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    private Long id;
    private Long examId;
    private Long codeId;

    private String name;
    private String article;
    private List<Selection> selections;

    private Integer answer;         // 정답

    private UserAccount createUser;
    private UserAccount updateUser;

    public Question(String name, Long examId) {
        this.name = name;
        this.examId = examId;
    }

    public Question(Long id, String name, Long codeId, Long examId, String article, Integer answer) {
        this.id = id;
        this.name = name;
        this.codeId = codeId;
        this.examId = examId;
        this.article = article;
        this.answer = answer;
    }

    public Question(Long id, String name, Long codeId, Long examId, String article, List<Selection> selections) {
        this.id = id;
        this.name = name;
        this.codeId = codeId;
        this.examId = examId;
        this.article = article;
        this.selections = selections;
    }

    public static Question of(String name, Long examId) {
        return new Question(name, examId);
    }

    public static Question of(Long id, String name, Long examId, Long codeId, String article, Integer answer) {
        return new Question(id, name, codeId, examId, article, answer);
    }

    public static Question of(Long id, String name, Long codeId, Long examId, String article, List<Selection> selections) {
        return new Question(id, name, codeId, examId, article, selections);
    }

    public QuestionEntity toEntity() {
        return QuestionEntity.of(this.name, this.examId);
    }
}

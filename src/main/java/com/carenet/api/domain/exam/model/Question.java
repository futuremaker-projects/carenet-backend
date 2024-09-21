package com.carenet.api.domain.exam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
    문제
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    private Long id;
    private Long examId;
    private String article;
    private Long codeId;
    private Integer answer;         // 정답

}

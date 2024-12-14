package com.carenet.api.domain.cbt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
    제출한 정답
        특정 모의고사의 문제 정답을 누가 풀었는지에 대한 정보
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Submission {

    private Long examId;
    private Long questionId;
    private Long userId;

    private Integer answer;     // 선택한 정답

    public Submission(Long examId, Long questionId, Integer answer, Long userId) {
        this.examId = examId;
        this.questionId = questionId;
        this.userId = userId;
        this.answer = answer;
    }

    public static Submission of(Long examId, Long questionId, Integer choice, Long userId) {
        return new Submission(examId, questionId, choice, userId);
    }

}

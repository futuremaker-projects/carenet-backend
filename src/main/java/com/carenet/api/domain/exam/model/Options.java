package com.carenet.api.domain.exam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
    객관식 문제
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Options {

    private Long questionId;
    private Long optionId;
    private String content;

    public static Options of(Long questionId, Long userId, String content) {
        return new Options(questionId, userId, content);
    }

}

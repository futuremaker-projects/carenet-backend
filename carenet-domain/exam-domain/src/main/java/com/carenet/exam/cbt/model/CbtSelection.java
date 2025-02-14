package com.carenet.exam.cbt.model;

import lombok.*;

import java.time.LocalDateTime;

/**
    CBT 객관식 문제 - 문제의 하위 객관식을 의미함
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CbtSelection {

    private Long questionId;
    private Long selectionId;
    private Long userId;
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CbtSelection of(Long questionId, Long selectionId, Long userId, String content) {
        return CbtSelection.builder()
                .questionId(questionId)
                .selectionId(selectionId)
                .userId(userId)
                .content(content)
                .build();
    }

    public static CbtSelection of(Long questionId, Long userId) {
        return CbtSelection.builder()
                .questionId(questionId)
                .userId(userId)
                .build();
    }

}

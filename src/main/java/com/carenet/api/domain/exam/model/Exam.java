package com.carenet.api.domain.exam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
    회차
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Exam {

    private Long id;
    private String title;

    public static Exam of(Long id, String title) {
        return new Exam(id, title);
    }

}

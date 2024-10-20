package com.carenet.api.domain.exam.model;

import com.carenet.api.domain.useraccount.UserAccount;
import com.carenet.api.infrastructure.exam.entity.ExamEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
    모의고사 회차
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Exam {

    private Long id;
    private String name;
    private int orders;
    private UserAccount userAccount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Exam(String name, int orders) {
        this.name = name;
        this.orders = orders;
    }

    public static Exam of(Long id, String name, int orders, UserAccount userAccount, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new Exam(id, name, orders, userAccount, createdAt, updatedAt);
    }

    public ExamEntity to() {
        return ExamEntity.of(this.name, this.orders);
    }

}

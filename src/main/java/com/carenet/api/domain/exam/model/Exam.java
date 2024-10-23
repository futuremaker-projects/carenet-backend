package com.carenet.api.domain.exam.model;

import com.carenet.api.domain.useraccount.UserAccount;
import com.carenet.api.infrastructure.exam.entity.ExamEntity;
import com.carenet.api.interfaces.dto.ExamDto;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
    모의고사 회차
 */
@Getter
@NoArgsConstructor
public class Exam {

    private Long id;
    private String name;
    private int orders;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserAccount createUser;
    private UserAccount updateUser;

    public Exam(String name, int orders) {
        this.name = name;
        this.orders = orders;
    }

    public static Exam of(Long id, String name, int orders,
                          LocalDateTime createdAt, LocalDateTime updatedAt
    ) {
        return new Exam(id, name, orders, createdAt, updatedAt, null, null);
    }

    public static Exam of(Long id, String name, int orders,
                          LocalDateTime createdAt, LocalDateTime updatedAt,
                          UserAccount createdBy, UserAccount updatedBy
    ) {
        return new Exam(id, name, orders, createdAt, updatedAt, createdBy, updatedBy);
    }

    // to save
    public ExamEntity to() {
        return ExamEntity.of(this.name, this.orders);
    }

    public static ExamDto.Response toDto(Exam exam) {
        return new ExamDto.Response(exam.getId(), exam.getName(), exam.getOrders(),
                exam.getCreatedAt(), exam.getUpdatedAt(),
                exam.getCreateUser(), exam.getUpdateUser()
        );
    }

    @QueryProjection
    public Exam(Long id, String name, int orders,
                LocalDateTime createdAt, LocalDateTime updatedAt,
                UserAccount createUser, UserAccount updateUser
    ) {
        this.id = id;
        this.name = name;
        this.orders = orders;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createUser = createUser;
        this.updateUser = updateUser;
    }

}

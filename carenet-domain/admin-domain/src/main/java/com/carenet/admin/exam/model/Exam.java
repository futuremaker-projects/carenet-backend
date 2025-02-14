package com.carenet.admin.exam.model;

import com.carenet.common.enums.ProgressType;
import com.carenet.user.userAccount.UserAccount;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
    모의고사 회차
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Exam {

    private Long id;
    private String name;
    private Integer orders;
    private ProgressType progressType;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserAccount createUser;
    private UserAccount updateUser;

    public Exam(Long id, String name, Integer orders, ProgressType progressType,
                LocalDateTime createdAt, LocalDateTime updatedAt,
                UserAccount createUser, UserAccount updateUser
    ) {
        this.id = id;
        this.name = name;
        this.orders = orders;
        this.progressType = progressType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createUser = createUser;
        this.updateUser = updateUser;
    }

    public Exam(String name, Integer orders) {
        this.name = name;
        this.orders = orders;
    }

    public static Exam of(Long id, String name, Integer orders, ProgressType progressType,
                          LocalDateTime createdAt, LocalDateTime updatedAt
    ) {
        return new Exam(id, name, orders, progressType, createdAt, updatedAt, null, null);
    }

    public static Exam of(Long id, String name, Integer orders, ProgressType progressType,
                          LocalDateTime createdAt, LocalDateTime updatedAt,
                          UserAccount createdBy, UserAccount updatedBy
    ) {
        return new Exam(id, name, orders, progressType, createdAt, updatedAt, createdBy, updatedBy);
    }

}

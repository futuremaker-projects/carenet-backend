package com.carenet.storage.exam.dto.exam.payload;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.carenet.storage.exam.dto.exam.payload.QExamPayload_Get is a Querydsl Projection type for Get
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QExamPayload_Get extends ConstructorExpression<ExamPayload.Get> {

    private static final long serialVersionUID = 235640356L;

    public QExamPayload_Get(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<Integer> orders, com.querydsl.core.types.Expression<com.carenet.common.enums.ProgressType> progressType, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdAt, com.querydsl.core.types.Expression<java.time.LocalDateTime> updatedAt, com.querydsl.core.types.Expression<Long> creatorId, com.querydsl.core.types.Expression<Long> updaterId, com.querydsl.core.types.Expression<? extends com.carenet.storage.exam.dto.userAccount.UserAccountResult.Get> createUser, com.querydsl.core.types.Expression<? extends com.carenet.storage.exam.dto.userAccount.UserAccountResult.Get> updateUse) {
        super(ExamPayload.Get.class, new Class<?>[]{long.class, String.class, int.class, com.carenet.common.enums.ProgressType.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, long.class, long.class, com.carenet.storage.exam.dto.userAccount.UserAccountResult.Get.class, com.carenet.storage.exam.dto.userAccount.UserAccountResult.Get.class}, id, name, orders, progressType, createdAt, updatedAt, creatorId, updaterId, createUser, updateUse);
    }

}


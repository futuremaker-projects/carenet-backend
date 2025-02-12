package com.carenet.storage.exam.dto.exam.payload;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.carenet.storage.exam.dto.exam.payload.QQuestionPayload_Get is a Querydsl Projection type for Get
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QQuestionPayload_Get extends ConstructorExpression<QuestionPayload.Get> {

    private static final long serialVersionUID = 763527549L;

    public QQuestionPayload_Get(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Long> examId, com.querydsl.core.types.Expression<Long> codeId, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> article, com.querydsl.core.types.Expression<? extends UserAccountPayload.Get> createUser, com.querydsl.core.types.Expression<? extends UserAccountPayload.Get> updateUser) {
        super(QuestionPayload.Get.class, new Class<?>[]{long.class, long.class, long.class, String.class, String.class, UserAccountPayload.Get.class, UserAccountPayload.Get.class}, id, examId, codeId, name, article, createUser, updateUser);
    }

}


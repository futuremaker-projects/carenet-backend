package com.carenet.storage.exam.dto.exam.payload;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.carenet.storage.exam.dto.exam.payload.QQuestionPayload_GetWithSelections is a Querydsl Projection type for GetWithSelections
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QQuestionPayload_GetWithSelections extends ConstructorExpression<QuestionPayload.GetWithSelections> {

    private static final long serialVersionUID = 1985739946L;

    public QQuestionPayload_GetWithSelections(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<Long> examId, com.querydsl.core.types.Expression<Long> codeId, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> article, com.querydsl.core.types.Expression<? extends UserAccountPayload.Get> createUser, com.querydsl.core.types.Expression<? extends UserAccountPayload.Get> updateUser, com.querydsl.core.types.Expression<? extends java.util.List<SelectionPayload.Get>> selections) {
        super(QuestionPayload.GetWithSelections.class, new Class<?>[]{long.class, long.class, long.class, String.class, String.class, UserAccountPayload.Get.class, UserAccountPayload.Get.class, java.util.List.class}, id, examId, codeId, name, article, createUser, updateUser, selections);
    }

}


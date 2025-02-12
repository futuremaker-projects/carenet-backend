package com.carenet.storage.exam.dto.exam.payload;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.carenet.storage.exam.dto.exam.payload.QSelectionPayload_Get is a Querydsl Projection type for Get
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QSelectionPayload_Get extends ConstructorExpression<SelectionPayload.Get> {

    private static final long serialVersionUID = 1109870813L;

    public QSelectionPayload_Get(com.querydsl.core.types.Expression<Long> questionId, com.querydsl.core.types.Expression<Long> selectionId, com.querydsl.core.types.Expression<String> content, com.querydsl.core.types.Expression<java.time.LocalDateTime> updatedAt, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdAt) {
        super(SelectionPayload.Get.class, new Class<?>[]{long.class, long.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class}, questionId, selectionId, content, updatedAt, createdAt);
    }

}


package com.carenet.storage.exam.dto.exam.payload;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.carenet.storage.exam.dto.exam.payload.QUserAccountPayload_Get is a Querydsl Projection type for Get
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserAccountPayload_Get extends ConstructorExpression<UserAccountPayload.Get> {

    private static final long serialVersionUID = -1449223161L;

    public QUserAccountPayload_Get(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> username) {
        super(UserAccountPayload.Get.class, new Class<?>[]{long.class, String.class}, id, username);
    }

}


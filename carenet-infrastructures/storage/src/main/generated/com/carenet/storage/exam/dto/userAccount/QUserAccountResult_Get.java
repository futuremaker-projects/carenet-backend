package com.carenet.storage.exam.dto.userAccount;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.carenet.storage.exam.dto.userAccount.QUserAccountResult_Get is a Querydsl Projection type for Get
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUserAccountResult_Get extends ConstructorExpression<UserAccountResult.Get> {

    private static final long serialVersionUID = 265173375L;

    public QUserAccountResult_Get(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> username) {
        super(UserAccountResult.Get.class, new Class<?>[]{long.class, String.class}, id, username);
    }

}


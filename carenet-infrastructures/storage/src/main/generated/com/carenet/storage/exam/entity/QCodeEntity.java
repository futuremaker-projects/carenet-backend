package com.carenet.storage.exam.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCodeEntity is a Querydsl query type for CodeEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCodeEntity extends EntityPathBase<CodeEntity> {

    private static final long serialVersionUID = -776318386L;

    public static final QCodeEntity codeEntity = new QCodeEntity("codeEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> orders = createNumber("orders", Integer.class);

    public final NumberPath<Long> parentId = createNumber("parentId", Long.class);

    public QCodeEntity(String variable) {
        super(CodeEntity.class, forVariable(variable));
    }

    public QCodeEntity(Path<? extends CodeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCodeEntity(PathMetadata metadata) {
        super(CodeEntity.class, metadata);
    }

}


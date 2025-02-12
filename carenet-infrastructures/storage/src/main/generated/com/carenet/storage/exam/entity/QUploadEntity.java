package com.carenet.storage.exam.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUploadEntity is a Querydsl query type for UploadEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUploadEntity extends EntityPathBase<UploadEntity> {

    private static final long serialVersionUID = -729922590L;

    public static final QUploadEntity uploadEntity = new QUploadEntity("uploadEntity");

    public final EnumPath<com.carenet.common.enums.ContentCategory> contentCategory = createEnum("contentCategory", com.carenet.common.enums.ContentCategory.class);

    public final NumberPath<Long> contentId = createNumber("contentId", Long.class);

    public final StringPath contentType = createString("contentType");

    public final StringPath fileName = createString("fileName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath path = createString("path");

    public final StringPath storedName = createString("storedName");

    public QUploadEntity(String variable) {
        super(UploadEntity.class, forVariable(variable));
    }

    public QUploadEntity(Path<? extends UploadEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUploadEntity(PathMetadata metadata) {
        super(UploadEntity.class, metadata);
    }

}


package com.carenet.storage.exam.entity.exam;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSelectionEntity is a Querydsl query type for SelectionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSelectionEntity extends EntityPathBase<SelectionEntity> {

    private static final long serialVersionUID = -1687809762L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSelectionEntity selectionEntity = new QSelectionEntity("selectionEntity");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final QSelectionComplexIds id;

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QSelectionEntity(String variable) {
        this(SelectionEntity.class, forVariable(variable), INITS);
    }

    public QSelectionEntity(Path<? extends SelectionEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSelectionEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSelectionEntity(PathMetadata metadata, PathInits inits) {
        this(SelectionEntity.class, metadata, inits);
    }

    public QSelectionEntity(Class<? extends SelectionEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QSelectionComplexIds(forProperty("id")) : null;
    }

}


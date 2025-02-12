package com.carenet.storage.exam.entity.cbt;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubmissionEntity is a Querydsl query type for SubmissionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubmissionEntity extends EntityPathBase<SubmissionEntity> {

    private static final long serialVersionUID = 661605318L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubmissionEntity submissionEntity = new QSubmissionEntity("submissionEntity");

    public final NumberPath<Integer> answer = createNumber("answer", Integer.class);

    public final QSubmissionComplexIds id;

    public QSubmissionEntity(String variable) {
        this(SubmissionEntity.class, forVariable(variable), INITS);
    }

    public QSubmissionEntity(Path<? extends SubmissionEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubmissionEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubmissionEntity(PathMetadata metadata, PathInits inits) {
        this(SubmissionEntity.class, metadata, inits);
    }

    public QSubmissionEntity(Class<? extends SubmissionEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QSubmissionComplexIds(forProperty("id")) : null;
    }

}


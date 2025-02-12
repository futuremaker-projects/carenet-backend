package com.carenet.storage.exam.entity.cbt;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubmissionHistoryEntity is a Querydsl query type for SubmissionHistoryEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubmissionHistoryEntity extends EntityPathBase<SubmissionHistoryEntity> {

    private static final long serialVersionUID = 229210196L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubmissionHistoryEntity submissionHistoryEntity = new QSubmissionHistoryEntity("submissionHistoryEntity");

    public final NumberPath<Integer> choice = createNumber("choice", Integer.class);

    public final QSubmissionHistoryComplexIds id;

    public QSubmissionHistoryEntity(String variable) {
        this(SubmissionHistoryEntity.class, forVariable(variable), INITS);
    }

    public QSubmissionHistoryEntity(Path<? extends SubmissionHistoryEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubmissionHistoryEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubmissionHistoryEntity(PathMetadata metadata, PathInits inits) {
        this(SubmissionHistoryEntity.class, metadata, inits);
    }

    public QSubmissionHistoryEntity(Class<? extends SubmissionHistoryEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QSubmissionHistoryComplexIds(forProperty("id")) : null;
    }

}


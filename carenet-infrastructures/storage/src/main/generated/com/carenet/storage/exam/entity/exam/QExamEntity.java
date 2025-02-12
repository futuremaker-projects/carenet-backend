package com.carenet.storage.exam.entity.exam;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QExamEntity is a Querydsl query type for ExamEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QExamEntity extends EntityPathBase<ExamEntity> {

    private static final long serialVersionUID = -1007866125L;

    public static final QExamEntity examEntity = new QExamEntity("examEntity");

    public final com.carenet.storage.QBaseEntity _super = new com.carenet.storage.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isRemoved = createBoolean("isRemoved");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> orders = createNumber("orders", Integer.class);

    public final EnumPath<com.carenet.common.enums.ProgressType> progressType = createEnum("progressType", com.carenet.common.enums.ProgressType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final NumberPath<Long> updatedBy = _super.updatedBy;

    public QExamEntity(String variable) {
        super(ExamEntity.class, forVariable(variable));
    }

    public QExamEntity(Path<? extends ExamEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExamEntity(PathMetadata metadata) {
        super(ExamEntity.class, metadata);
    }

}


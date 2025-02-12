package com.carenet.storage.exam.entity.exam;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QQuestionEntity is a Querydsl query type for QuestionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestionEntity extends EntityPathBase<QuestionEntity> {

    private static final long serialVersionUID = -1498672902L;

    public static final QQuestionEntity questionEntity = new QQuestionEntity("questionEntity");

    public final com.carenet.storage.QBaseEntity _super = new com.carenet.storage.QBaseEntity(this);

    public final NumberPath<Integer> answer = createNumber("answer", Integer.class);

    public final StringPath article = createString("article");

    public final NumberPath<Long> codeId = createNumber("codeId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    public final NumberPath<Long> examId = createNumber("examId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final EnumPath<com.carenet.common.enums.ProgressType> progressType = createEnum("progressType", com.carenet.common.enums.ProgressType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final NumberPath<Long> updatedBy = _super.updatedBy;

    public QQuestionEntity(String variable) {
        super(QuestionEntity.class, forVariable(variable));
    }

    public QQuestionEntity(Path<? extends QuestionEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQuestionEntity(PathMetadata metadata) {
        super(QuestionEntity.class, metadata);
    }

}


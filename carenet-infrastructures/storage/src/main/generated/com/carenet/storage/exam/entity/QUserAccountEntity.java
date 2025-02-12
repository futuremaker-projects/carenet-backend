package com.carenet.storage.exam.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserAccountEntity is a Querydsl query type for UserAccountEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserAccountEntity extends EntityPathBase<UserAccountEntity> {

    private static final long serialVersionUID = -836726137L;

    public static final QUserAccountEntity userAccountEntity = new QUserAccountEntity("userAccountEntity");

    public final com.carenet.storage.QBaseEntity _super = new com.carenet.storage.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isRemoved = createBoolean("isRemoved");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final NumberPath<Long> updatedBy = _super.updatedBy;

    public final StringPath username = createString("username");

    public QUserAccountEntity(String variable) {
        super(UserAccountEntity.class, forVariable(variable));
    }

    public QUserAccountEntity(Path<? extends UserAccountEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserAccountEntity(PathMetadata metadata) {
        super(UserAccountEntity.class, metadata);
    }

}


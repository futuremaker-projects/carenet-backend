package com.carenet.storage.exam.entity.cbt;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubmissionComplexIds is a Querydsl query type for SubmissionComplexIds
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QSubmissionComplexIds extends BeanPath<SubmissionComplexIds> {

    private static final long serialVersionUID = 1006893643L;

    public static final QSubmissionComplexIds submissionComplexIds = new QSubmissionComplexIds("submissionComplexIds");

    public final NumberPath<Long> examId = createNumber("examId", Long.class);

    public final NumberPath<Long> questionId = createNumber("questionId", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QSubmissionComplexIds(String variable) {
        super(SubmissionComplexIds.class, forVariable(variable));
    }

    public QSubmissionComplexIds(Path<? extends SubmissionComplexIds> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubmissionComplexIds(PathMetadata metadata) {
        super(SubmissionComplexIds.class, metadata);
    }

}


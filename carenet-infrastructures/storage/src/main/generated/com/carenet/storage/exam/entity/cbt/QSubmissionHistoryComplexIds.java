package com.carenet.storage.exam.entity.cbt;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubmissionHistoryComplexIds is a Querydsl query type for SubmissionHistoryComplexIds
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QSubmissionHistoryComplexIds extends BeanPath<SubmissionHistoryComplexIds> {

    private static final long serialVersionUID = -384225319L;

    public static final QSubmissionHistoryComplexIds submissionHistoryComplexIds = new QSubmissionHistoryComplexIds("submissionHistoryComplexIds");

    public final NumberPath<Long> examId = createNumber("examId", Long.class);

    public final NumberPath<Long> questionId = createNumber("questionId", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QSubmissionHistoryComplexIds(String variable) {
        super(SubmissionHistoryComplexIds.class, forVariable(variable));
    }

    public QSubmissionHistoryComplexIds(Path<? extends SubmissionHistoryComplexIds> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubmissionHistoryComplexIds(PathMetadata metadata) {
        super(SubmissionHistoryComplexIds.class, metadata);
    }

}


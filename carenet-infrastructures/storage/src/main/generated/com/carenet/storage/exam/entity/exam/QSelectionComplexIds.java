package com.carenet.storage.exam.entity.exam;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSelectionComplexIds is a Querydsl query type for SelectionComplexIds
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QSelectionComplexIds extends BeanPath<SelectionComplexIds> {

    private static final long serialVersionUID = -1578609757L;

    public static final QSelectionComplexIds selectionComplexIds = new QSelectionComplexIds("selectionComplexIds");

    public final NumberPath<Long> questionId = createNumber("questionId", Long.class);

    public final NumberPath<Long> selectionId = createNumber("selectionId", Long.class);

    public QSelectionComplexIds(String variable) {
        super(SelectionComplexIds.class, forVariable(variable));
    }

    public QSelectionComplexIds(Path<? extends SelectionComplexIds> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSelectionComplexIds(PathMetadata metadata) {
        super(SelectionComplexIds.class, metadata);
    }

}


package com.carenet.storage.exam.repository.exam;

import com.carenet.common.exception.ApplicationException;
import com.carenet.common.exception.ErrorCode;
import com.carenet.storage.Utils;
import com.carenet.storage.exam.dto.exam.payload.*;
import com.carenet.storage.exam.dto.exam.statement.QuestionStatement;
import com.carenet.storage.exam.entity.QUserAccountEntity;
import com.carenet.storage.exam.entity.exam.QuestionEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.carenet.storage.exam.entity.exam.QQuestionEntity.questionEntity;
import static com.carenet.storage.exam.entity.exam.QSelectionEntity.selectionEntity;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;

@Repository
public class QuestionJpaQuerySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public QuestionJpaQuerySupport(JPAQueryFactory queryFactory) {
        super(QuestionEntity.class);
        this.queryFactory = queryFactory;
    }

    /**
     * 문제 목록조회
     */
    public Slice<QuestionPayload.Get> getQuestionsByExamId(Pageable pageable, QuestionStatement.Get statement) {
        QUserAccountEntity createUser = new QUserAccountEntity("createUser");
        QUserAccountEntity updateUser = new QUserAccountEntity("updateUser");

        List<QuestionPayload.Get> list = queryFactory.select(
                        new QQuestionPayload_Get(
                                questionEntity.id, questionEntity.examId, questionEntity.codeId,
                                questionEntity.name, questionEntity.article,
                                new QUserAccountPayload_Get(createUser.id, createUser.username),
                                new QUserAccountPayload_Get(updateUser.id, updateUser.username)
                        ))
                .from(questionEntity)
                .leftJoin(createUser).on(createUser.id.eq(questionEntity.createdBy))
                .leftJoin(updateUser).on(updateUser.id.eq(questionEntity.updatedBy))
                .where(questionEntity.examId.eq(statement.examId()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .orderBy(Utils.getOrderList(pageable.getSort(), QuestionEntity.class))
                .fetch();
        return new SliceImpl<>(list, pageable, Utils.hasNext(list, pageable.getPageSize()));
    }

    /**
        모의고사의 모든 문제 및 하위 객관식 문제 조회 - cbt 용
     */
    public List<QuestionPayload.GetWithSelections> getQuestionsByExamId(QuestionStatement.Get statement) {
        QUserAccountEntity createUser = new QUserAccountEntity("createUser");
        QUserAccountEntity updateUser = new QUserAccountEntity("updateUser");

        Map<QuestionEntity, QuestionPayload.GetWithSelections> result = queryFactory.from(questionEntity)
                .leftJoin(createUser).on(createUser.id.eq(questionEntity.createdBy))
                .leftJoin(updateUser).on(updateUser.id.eq(questionEntity.updatedBy))
                .leftJoin(selectionEntity).on(selectionEntity.id.questionId.eq(questionEntity.id))
                .where(questionEntity.examId.eq(statement.examId()))
                .transform(groupBy(questionEntity).as(
                        new QQuestionPayload_GetWithSelections(
                                questionEntity.id, questionEntity.examId, questionEntity.codeId,
                                questionEntity.name, questionEntity.article,
                                new QUserAccountPayload_Get(createUser.id, createUser.username),
                                new QUserAccountPayload_Get(updateUser.id, updateUser.username),
                                list(new QSelectionPayload_Get(
                                        selectionEntity.id.questionId, selectionEntity.id.selectionId,
                                        selectionEntity.content, selectionEntity.createdAt,
                                        selectionEntity.updatedAt
                                ))
                        ))
                );
        return result.keySet().stream().map(result::get).toList();
    }

    public Long getTotalCountByExamId(QuestionStatement.Search search, Long examId) {
        return queryFactory.select(questionEntity.id.count()).from(questionEntity)
                .where(questionEntity.examId.eq(examId).and(searchByConditions(search)))
                .fetchOne();
    }

    /**
     * 문제 단일조회
     */
    public QuestionPayload.GetWithSelections getQuestion(Long questionId) {
        QUserAccountEntity createUser = new QUserAccountEntity("createUser");
        QUserAccountEntity updateUser = new QUserAccountEntity("updateUser");

        Map<QuestionEntity, QuestionPayload.GetWithSelections> result = queryFactory.from(questionEntity)
                .leftJoin(selectionEntity).on(selectionEntity.id.questionId.eq(questionId))
                .leftJoin(createUser).on(createUser.id.eq(questionEntity.createdBy))
                .leftJoin(updateUser).on(updateUser.id.eq(questionEntity.updatedBy))
                .where(questionEntity.id.eq(questionId))
                .transform(groupBy(questionEntity).as(new QQuestionPayload_GetWithSelections(
                        questionEntity.id, questionEntity.examId, questionEntity.codeId,
                        questionEntity.name, questionEntity.article,
                        new QUserAccountPayload_Get(createUser.id, createUser.username),
                        new QUserAccountPayload_Get(updateUser.id, updateUser.username),
                        list(new QSelectionPayload_Get(
                                selectionEntity.id.questionId, selectionEntity.id.selectionId,
                                selectionEntity.content, selectionEntity.createdAt, selectionEntity.updatedAt
                        ))
                )));
        return result.values().stream().findFirst().orElseThrow(
                () -> new ApplicationException(ErrorCode.CONTENT_NOT_FOUND, "question not found : id - %d".formatted(questionId)));
    }

    private BooleanBuilder searchByConditions(QuestionStatement.Search search) {
        BooleanBuilder builder = new BooleanBuilder();
        return builder;
    }
}

package com.carenet.api.infrastructure.exam.repository.exam;

import com.carenet.api.infrastructure.Utils;
import com.carenet.api.infrastructure.exam.dto.result.QQuestionPayload_Get;
import com.carenet.api.infrastructure.exam.dto.result.QuestionPayload;
import com.carenet.api.infrastructure.exam.dto.statement.QuestionStatement;
import com.carenet.api.infrastructure.exam.entity.QuestionEntity;
import com.carenet.api.infrastructure.useraccount.QUserAccountEntity;
import com.carenet.api.infrastructure.useraccount.dto.QUserAccountResult_Get;
import com.carenet.api.interfaces.question.dto.SearchQuestionDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.carenet.api.infrastructure.exam.entity.QQuestionEntity.questionEntity;

@Repository
public class QuestionJpaQuerySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public QuestionJpaQuerySupport(JPAQueryFactory queryFactory) {
        super(QuestionEntity.class);
        this.queryFactory = queryFactory;
    }

    public Slice<QuestionPayload.Get> getQuestionsByExamId(Pageable pageable, QuestionStatement.Get statement) {
        QUserAccountEntity createUser = new QUserAccountEntity("createUser");
        QUserAccountEntity updateUser = new QUserAccountEntity("updateUser");

        List<QuestionPayload.Get> list = queryFactory.select(
                        new QQuestionPayload_Get(
                                questionEntity.id, questionEntity.examId, questionEntity.codeId,
                                questionEntity.name, questionEntity.article,
                                new QUserAccountResult_Get(createUser.id, createUser.username),
                                new QUserAccountResult_Get(updateUser.id, updateUser.username)
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

    public Long getTotalCountByExamId(SearchQuestionDto.Search search, Long examId) {
        return queryFactory.select(questionEntity.id.count()).from(questionEntity)
                .where(questionEntity.examId.eq(examId).and(searchByConditions(search)))
                .fetchOne();
    }


    private BooleanBuilder searchByConditions(SearchQuestionDto.Search search) {
        BooleanBuilder builder = new BooleanBuilder();

        return builder;
    }
}

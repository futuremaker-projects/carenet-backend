package com.carenet.storage.exam.repository.exam;

import com.carenet.storage.Utils;
import com.carenet.storage.exam.dto.exam.payload.ExamPayload;
import com.carenet.storage.exam.dto.exam.payload.QExamPayload_Get;
import com.carenet.storage.exam.dto.exam.statement.ExamStatement;
import com.carenet.storage.exam.dto.userAccount.QUserAccountResult_Get;
import com.carenet.storage.exam.entity.QUserAccountEntity;
import com.carenet.storage.exam.entity.exam.ExamEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.carenet.storage.exam.entity.exam.QExamEntity.examEntity;


@Repository
public class ExamJpaQuerySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public ExamJpaQuerySupport(JPAQueryFactory queryFactory) {
        super(ExamEntity.class);
        this.queryFactory = queryFactory;
    }

    public Slice<ExamPayload.Get> getExams(Pageable pageable, ExamStatement.Search search) {
        QUserAccountEntity createdBy = new QUserAccountEntity("createdBy");
        QUserAccountEntity updatedBy = new QUserAccountEntity("updatedBy");
        List<ExamPayload.Get> list = queryFactory.select(
                        new QExamPayload_Get(
                                examEntity.id, examEntity.name,
                                examEntity.orders, examEntity.progressType,
                                examEntity.createdAt, examEntity.updatedAt,
                                examEntity.createdBy, examEntity.updatedBy,
                                new QUserAccountResult_Get(createdBy.id, createdBy.username),
                                new QUserAccountResult_Get(updatedBy.id, updatedBy.username)
                        ))
                .from(examEntity)
                .leftJoin(createdBy).on(examEntity.createdBy.eq(createdBy.createdBy))
                .leftJoin(updatedBy).on(examEntity.updatedBy.eq(updatedBy.createdBy))
                .where(searchByConditions(search))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .orderBy(Utils.getOrderList(pageable.getSort(), ExamEntity.class))
                .fetch();

        return new SliceImpl<>(list, pageable, Utils.hasNext(list, pageable.getPageSize()));
    }

    public Long totalExamCount(ExamStatement.Search search) {
        return queryFactory.select(examEntity.id.count())
                .from(examEntity).where(searchByConditions(search)).fetchOne();
    }

    private BooleanBuilder searchByConditions(ExamStatement.Search search) {
        BooleanBuilder builder = new BooleanBuilder();
        return builder
                .and(examNameEq(search.name()));
    }

    private BooleanExpression examNameEq(String name) {
        /** like (string), contains (%string%), startWith (string%), endWith(%string) */
        return StringUtils.hasText(name) ? examEntity.name.contains(name) : null;
    }

}

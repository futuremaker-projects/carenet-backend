package com.carenet.api.infrastructure.exam.repository.exam;

import com.carenet.api.domain.useraccount.QUserAccount;
import com.carenet.api.infrastructure.Utils;
import com.carenet.api.infrastructure.exam.dto.ExamResult;
import com.carenet.api.infrastructure.exam.dto.QExamResult_Get;
import com.carenet.api.infrastructure.exam.entity.ExamEntity;
import com.carenet.api.infrastructure.useraccount.QUserAccountEntity;
import com.carenet.api.infrastructure.useraccount.dto.QUserAccountResult_Get;
import com.carenet.api.interfaces.dto.SearchExamDto;
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

import static com.carenet.api.infrastructure.exam.entity.QExamEntity.examEntity;

@Repository
public class ExamJpaQuerySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public ExamJpaQuerySupport(JPAQueryFactory queryFactory) {
        super(ExamEntity.class);
        this.queryFactory = queryFactory;
    }

    public Slice<ExamResult.Get> getExams(Pageable pageable, SearchExamDto.GetExams search) {
        QUserAccountEntity createdBy = new QUserAccountEntity("createdBy");
        QUserAccountEntity updatedBy = new QUserAccountEntity("updatedBy");
        List<ExamResult.Get> list = queryFactory.select(
                        new QExamResult_Get(
                                examEntity.id, examEntity.name, examEntity.orders,
                                examEntity.createdAt, examEntity.updatedAt,
                                examEntity.createdBy, examEntity.updatedBy,
                                new QUserAccountResult_Get(createdBy.id, createdBy.username),
                                new QUserAccountResult_Get(updatedBy.id, updatedBy.username)
                        ))
                .from(examEntity)
                .leftJoin(createdBy).on(examEntity.createdBy.eq(createdBy.createdBy))
                .leftJoin(updatedBy).on(examEntity.updatedBy.eq(updatedBy.createdBy))
                .where(getBooleanBuilder(search))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .orderBy(Utils.getOrderList(pageable.getSort(), ExamEntity.class))
                .fetch();

        return new SliceImpl<>(list, pageable, hasNext(list, pageable.getPageSize()));
    }

    public Long totalExamCount(SearchExamDto.GetExams search) {
        return queryFactory.select(examEntity.id.count())
                .from(examEntity).where(getBooleanBuilder(search)).fetchOne();
    }

    private <T> Boolean hasNext(List<T> contents, int pageSize) {
        if (contents.size() > pageSize) {
            contents.remove(pageSize);
            return true;
        }
        return false;
    }

    private BooleanBuilder getBooleanBuilder(SearchExamDto.GetExams search) {
        BooleanBuilder builder = new BooleanBuilder();
        return builder
                .and(examNameEq(search.name()));
    }

    private BooleanExpression examNameEq(String name) {
        /** like (string), contains (%string%), startWith (string%), endWith(%string) */
        return StringUtils.hasText(name) ? examEntity.name.contains(name) : null;
    }

}

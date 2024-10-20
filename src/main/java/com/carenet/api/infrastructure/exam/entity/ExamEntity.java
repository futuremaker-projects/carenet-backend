package com.carenet.api.infrastructure.exam.entity;

import com.carenet.api.domain.exam.model.Exam;
import com.carenet.api.infrastructure.BaseEntity;
import com.carenet.api.infrastructure.useraccount.UserAccountEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.Objects;

/** 모의고사 회차 */
@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE exam SET is_removed = true WHERE id = ?")
@SQLRestriction("is_removed = false")
@Table(name = "exam")
public class ExamEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '모의고사 명'")
    private String name;

    @Column(columnDefinition = "int DEFAULT 0 COMMENT '정렬순서'")
    private int orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private UserAccountEntity userAccountEntity;

    @Setter
    @Column(columnDefinition = "bit default false NOT NULL COMMENT '삭제여부'")
    private boolean isRemoved;

    public ExamEntity(String name, int orders) {
        this.name = name;
        this.orders = orders;
    }

    public static ExamEntity of(String name, int orders) {
        return new ExamEntity(name, orders);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamEntity examEntity)) return false;
        return id != null && id.equals(examEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Exam toDomain() {
        return Exam.of(id, name, orders, userAccountEntity.toDomain(), getCreatedAt(), getUpdatedAt());
    }

}

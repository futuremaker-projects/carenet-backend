package com.carenet.storage.exam.entity.exam;

import com.carenet.admin.exam.model.Exam;
import com.carenet.common.enums.ProgressType;
import com.carenet.storage.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(50) default 'IN_PROGRESS' comment '진행상태'")
    private ProgressType progressType;

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
        return Exam.of(id, name, orders, progressType, getCreatedAt(), getUpdatedAt());
    }

}

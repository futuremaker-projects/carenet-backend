package com.carenet.api.infrastructure;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @Column(columnDefinition = "bigint COMMENT '등록자'")
    private Long createdBy;
    @Column(columnDefinition = "bigint COMMENT '수정자'")
    private Long updatedBy;

    @Comment("등록일")
    private LocalDateTime createdAt;
    @Comment("수정일")
    private LocalDateTime updatedAt;

    @PrePersist
    void createdAt() {
        this.createdBy = 1L;    // 인증 적용 후 삭제 필요
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    void updatedAt() {
        this.updatedBy = 1L;
        this.updatedAt = LocalDateTime.now();
    }

}

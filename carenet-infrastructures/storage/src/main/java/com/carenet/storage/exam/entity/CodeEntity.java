package com.carenet.storage.exam.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        name = "code",
        indexes = @Index(name = "idx_userId", columnList = "user_id")
)
public class CodeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private Long id;

    @Column(columnDefinition = "varchar(50) not null comment '코드명'")
    private String name;

    @Column(columnDefinition = "int unsigned comment '순서'")
    private Integer orders;

    /** 코드가 검색될 관리자 id */
    @Column(columnDefinition = "int unsigned not null comment '사용자 id'")
    private Long userId;

    @Column(columnDefinition = "int unsigned comment '순서'")
    private Long parentId;

    @Column(columnDefinition = "int unsigned comment ''")
    private Integer questionCount;

}


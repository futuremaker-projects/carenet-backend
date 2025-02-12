package com.carenet.storage.exam.entity;

import com.carenet.storage.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.Objects;

/** 사용자 */
@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE user_account SET is_removed = true WHERE id = ?")
@SQLRestriction("is_removed = false")
@Table(name = "user_account")
public class UserAccountEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(columnDefinition = "bit DEFAULT false NOT NULL COMMENT '삭제여부'")
    private boolean isRemoved;

    public UserAccountEntity(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public static UserAccountEntity of(Long id, String username) {
        return new UserAccountEntity(id, username);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccountEntity userAccountEntity)) return false;
        return id != null && id.equals(userAccountEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


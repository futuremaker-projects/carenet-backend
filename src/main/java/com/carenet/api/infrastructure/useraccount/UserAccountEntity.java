package com.carenet.api.infrastructure.useraccount;

import com.carenet.api.domain.useraccount.UserAccount;
import com.carenet.api.infrastructure.BaseEntity;
import com.carenet.api.infrastructure.exam.entity.ExamEntity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

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

    private String name;

    @Column(columnDefinition = "bit DEFAULT false NOT NULL COMMENT '삭제여부'")
    private boolean isRemoved;

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

    public UserAccount toDomain() {
        return new UserAccount(this.id, this.name);
    }

}


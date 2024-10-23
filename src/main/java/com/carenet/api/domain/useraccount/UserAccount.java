package com.carenet.api.domain.useraccount;

import com.carenet.api.infrastructure.useraccount.UserAccountEntity;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserAccount {

    private Long id;
    private String username;

    public UserAccount(Long id) {
        this.id = id;
    }

    public static UserAccount of(Long id) {
        return new UserAccount(id);
    }

    public static UserAccount of(Long id, String username) {
        return new UserAccount(id, username);
    }

    public UserAccountEntity toEntity() {
        return UserAccountEntity.of(this.id, this.username);
    }

    @QueryProjection
    public UserAccount(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}

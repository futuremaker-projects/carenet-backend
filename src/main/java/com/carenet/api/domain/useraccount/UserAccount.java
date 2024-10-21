package com.carenet.api.domain.useraccount;

import com.carenet.api.infrastructure.useraccount.UserAccountEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
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

    public UserAccountEntity toEntity() {
        return new UserAccountEntity(this.id, this.username);
    }
}

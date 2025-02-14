package com.carenet.user.userAccount;

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

    public UserAccount(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public static UserAccount of(Long id) {
        return new UserAccount(id);
    }

    public static UserAccount of(Long id, String username) {
        return new UserAccount(id, username);
    }

}

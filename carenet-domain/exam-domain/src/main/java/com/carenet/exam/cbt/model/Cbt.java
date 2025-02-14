package com.carenet.exam.cbt.model;

import com.carenet.user.userAccount.UserAccount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cbt {

    private List<CbtQuestion> questions;

    private UserAccount userAccount;

}

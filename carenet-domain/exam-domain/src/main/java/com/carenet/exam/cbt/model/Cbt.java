package com.carenet.exam.cbt.model;

import com.carenet.exam.exam.model.Question;
import com.carenet.exam.userAccount.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cbt {

    private List<Question> questions;

    private UserAccount userAccount;

}

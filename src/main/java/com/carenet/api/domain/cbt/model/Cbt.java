package com.carenet.api.domain.cbt.model;

import com.carenet.api.domain.exam.model.Question;
import com.carenet.api.domain.useraccount.UserAccount;
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

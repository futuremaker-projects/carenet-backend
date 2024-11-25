package com.carenet.api.domain.cbt;

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

    // todo: 글자크기, 화면보기는 사용자마다 저장해야 될 사항인지 확인필요
    private UserAccount userAccount;

}

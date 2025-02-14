package com.carenet.exam.cbt.model;

import com.carenet.user.userAccount.UserAccount;
import lombok.*;

import java.util.List;

/**
    Cbt 문제 정보
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CbtQuestion {

    private Long id;
    private Long examId;
    private Long codeId;

    private String name;
    private String article;
    private List<CbtSelection> selections;

    private Integer answer;         // 정답

    private UserAccount createUser;
    private UserAccount updateUser;

}

package com.carenet.exam.code;

public class Code {

    public Long id;
    public String name;

    /**
        모의고사의 문제의 생성 수를 제한하기 위해 사용
            1. 총 출제될수 있는 문제의 수 제한
            2. 하위 코드에 등록된 문제의 수를 확인하여 하위코드가 등록된 문제에 대해서 구분이 되도록 하자
     */
    public Integer amount;

}

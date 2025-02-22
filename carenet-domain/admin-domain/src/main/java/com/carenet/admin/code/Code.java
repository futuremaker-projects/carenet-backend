package com.carenet.admin.code;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
    캐시 처리를 위해 데이터를 어떻게 처리할 지 고민해야 함
        물론 캐시 데이터는 계층형으로 만들고 저장해야 함
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class Code {

    private Long id;
    private String name;
    private Long parentId;
    private Integer orders;
    private Long userId;

    @Builder.Default
    private List<Code> children = new ArrayList<>();

    /**
        모의고사의 문제의 생성 수를 제한하기 위해 사용
            1. 총 출제될수 있는 문제의 수 제한
            2. 하위 코드에 등록된 문제의 수를 확인하여 하위코드가 등록된 문제에 대해서 구분이 되도록 하자
     */
    private Integer questionCount;

    public static Code of(Long id, String name, Long parentId, Long userId,
                          Integer orders, Integer questionCount) {
        return Code.builder()
                .id(id)
                .name(name)
                .parentId(parentId)
                .userId(userId)
                .orders(orders)
                .questionCount(questionCount)
                .build();
    }

    public static Code of(Long id, String name, Long parentId) {
        return Code.builder().id(id).name(name).parentId(parentId).build();
    }

    /** set or hash 로 계층형 로직 변경 대비 (중복된 Code가 들어가면 Set으로 자료구조 변경 필요)*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Code code)) return false;
        return id != null && id.equals(code.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

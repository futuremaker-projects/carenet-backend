package com.carenet.admin.code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CodeServiceTest {

    @InjectMocks
    private CodeService sut;

    @Mock
    private CodeCacheManager codeCacheManager;

    @DisplayName("관리자 id를 이용하여 코드 목록을 조회한다.")
    @Test
    void givenUserId_whenSearchingCodesByUserId_thenReturnCodes() {
        // given
        Long userId = 1L;

        List<Code> findCodes = List.of(
                Code.of(1L, "name1", null),
                Code.of(2L, "name2", 1L),
                Code.of(3L, "name3", 1L)
        );
        given(codeCacheManager.getFlatCodes(userId)).willReturn(findCodes);

        // when
        List<Code> codes = sut.getCodes(userId);

        // then
        Assertions.assertThat(codes.isEmpty()).isEqualTo(false);
    }

    @DisplayName("코드 flatList를 이용하여 연관된 자식 코드를 children 필드로 추가한다.")
    @Test
    void given_when_then1() {
        // given

        // when

        // then
    }


    @Test
    void given_when_then2() {
        // given

        // when

        // then
    }

}
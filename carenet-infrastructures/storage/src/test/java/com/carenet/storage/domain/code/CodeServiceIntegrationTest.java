package com.carenet.storage.domain.code;

import com.carenet.admin.code.Code;
import com.carenet.admin.code.CodeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(CodeService.class)
public class CodeServiceIntegrationTest {

    @Autowired
    private CodeService sut;

    @DisplayName("관리자 id를 이용하여 해당 관리자가 등록한 코드값의 계층형 코드 목록을 조회한다.")
    @Test
    void given_when_then() {
        // given
        Long userId = 1L;

        // when
        List<Code> codes = sut.getHierarchyCodes(1L);

        // then
        assertThat(codes).hasSize(2);

        Code root1 = codes.get(0);
        Code root2 = codes.get(1);

        assertThat(root1.getId()).isEqualTo(1L);
        assertThat(root1.getChildren()).hasSize(3);
        assertThat(root1.getChildren().get(0).getId()).isEqualTo(2L);
        assertThat(root1.getChildren().get(0).getChildren()).hasSize(1);

        assertThat(root2.getId()).isEqualTo(8L);
        assertThat(root2.getChildren()).hasSize(1);
        assertThat(root2.getChildren().get(0).getChildren()).hasSize(1);
        assertThat(root2.getChildren().get(0).getChildren().get(0).getId()).isEqualTo(10L);
    }

}

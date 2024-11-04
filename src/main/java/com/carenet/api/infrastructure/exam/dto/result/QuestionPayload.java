package com.carenet.api.infrastructure.exam.dto.result;

import com.carenet.api.domain.exam.model.Question;
import com.carenet.api.infrastructure.useraccount.dto.UserAccountResult;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class QuestionPayload {

    @Getter
    @AllArgsConstructor
    public static class Get {

        private Long id;
        private Long examId;
        private Long codeId;
        private String name;
        private String article;
        private Integer answer;
        private List<SelectionPayload.Get> options;

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private UserAccountResult.Get createUser;
        private UserAccountResult.Get updateUser;

        @QueryProjection
        public Get(Long id, Long examId, Long codeId, String name, String article,
                   UserAccountResult.Get createUser, UserAccountResult.Get updateUser
        ) {
            this.id = id;
            this.examId = examId;
            this.codeId = codeId;
            this.name = name;
            this.article = article;
            this.createUser = createUser;
            this.updateUser = updateUser;
        }

        public Question toDomain() {
            return Question.of(
                    this.id, this.name, this.examId, this.codeId, this.article, this.answer
            );
        }

    }

}

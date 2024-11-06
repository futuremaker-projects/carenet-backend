package com.carenet.api.infrastructure.exam.dto.payload;

import com.carenet.api.domain.exam.model.Question;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private UserAccountPayload.Get createUser;
        private UserAccountPayload.Get updateUser;

        @QueryProjection
        public Get(Long id, Long examId, Long codeId, String name, String article,
                   UserAccountPayload.Get createUser, UserAccountPayload.Get updateUser
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
                    this.id, this.name, this.examId,
                    this.codeId, this.article, this.answer
            );
        }
    }

    @Getter
    @NoArgsConstructor
    public static class GetWithSelections {

        private Long id;
        private Long examId;
        private Long codeId;
        private String name;
        private String article;
        private Integer answer;

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private UserAccountPayload.Get createUser;
        private UserAccountPayload.Get updateUser;

        private List<SelectionPayload.Get> selections;

        @QueryProjection
        public GetWithSelections(Long id, Long examId, Long codeId, String name, String article,
                   UserAccountPayload.Get createUser, UserAccountPayload.Get updateUser,
                   List<SelectionPayload.Get> selections
        ) {
            this.id = id;
            this.examId = examId;
            this.codeId = codeId;
            this.name = name;
            this.article = article;
            this.createUser = createUser;
            this.updateUser = updateUser;
            this.selections = selections;
        }

        public Question toDomain() {
            return Question.of(
                    this.id, this.name,
                    this.examId, this.codeId,
                    this.article,
                    selections.stream().map(SelectionPayload.Get::toDomain).toList()
            );
        }

    }

}

package com.carenet.api.infrastructure.exam.dto.payload;

import com.carenet.api.domain.exam.model.Exam;
import com.carenet.api.domain.exam.model.enums.ProgressType;
import com.carenet.api.infrastructure.useraccount.dto.UserAccountResult;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/* response */
public class ExamPayload {

    @Getter
    @NoArgsConstructor
    public static class Get {
        private Long id;
        private String name;
        private int orders;
        private ProgressType progressType;

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Long creatorId;
        private Long updaterId;
        private UserAccountResult.Get createUser;
        private UserAccountResult.Get updateUse;

        @QueryProjection
        public Get(Long id, String name, int orders, ProgressType progressType,
                   LocalDateTime createdAt, LocalDateTime updatedAt,
                   Long creatorId, Long updaterId,
                   UserAccountResult.Get createUser, UserAccountResult.Get updateUse
        ) {
            this.id = id;
            this.name = name;
            this.orders = orders;
            this.progressType = progressType;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.creatorId = creatorId;
            this.updaterId = updaterId;
            this.createUser = createUser;
            this.updateUse = updateUse;
        }

        public Exam toDomain() {
            return Exam.of(
                    this.id, this.name, this.orders, this.progressType, this.createdAt, this.updatedAt,
                    this.createUser.toDomain(), this.createUser.toDomain()
            );
        }

    }

}

package com.carenet.api.interfaces.exam.dto;

import com.carenet.api.domain.exam.model.Exam;
import com.carenet.api.domain.exam.model.enums.ProgressType;
import com.carenet.api.domain.useraccount.UserAccount;

import java.time.LocalDateTime;

public class ExamDto {
    public record Request(String name, int orders) {
        public Exam to() {
            return new Exam(this.name, this.orders);
        }

        public static Request of(String name) {
            return new Request(name, 0);
        }
    }

    public record Response(Long id, String name, int orders, ProgressType progressType,
                           LocalDateTime createdAt, LocalDateTime updatedAt,
                           UserAccount createUser, UserAccount updateUser) {
        public static Response of(Exam exam) {
            return new Response(
                    exam.getId(), exam.getName(), exam.getOrders(), exam.getProgressType(),
                    exam.getCreatedAt(), exam.getUpdatedAt(),
                    exam.getCreateUser(), exam.getUpdateUser()
            );
        }
    }

    public record Search(String name) {

    }

}

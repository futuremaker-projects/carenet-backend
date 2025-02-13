package com.carenet.examapi.interfaces.dto;

import com.carenet.common.enums.ProgressType;
import com.carenet.exam.exam.dto.command.ExamCommand;
import com.carenet.exam.exam.model.Exam;
import com.carenet.exam.userAccount.UserAccount;

import java.time.LocalDateTime;

public class ExamDto {
    public record Create(String name, int orders) {
        public ExamCommand.Create toCommand() {
            return ExamCommand.Create.of(this.name, this.orders);
        }

        public static Create of(String name) {
            return new Create(name, 0);
        }
    }

    public record Response(Long id, String name, int orders, ProgressType progressType,
                           LocalDateTime createdAt, LocalDateTime updatedAt,
                           UserAccount createUser, UserAccount updateUser) {
        public static Response from(Exam exam) {
            return new Response(
                    exam.getId(), exam.getName(), exam.getOrders(), exam.getProgressType(),
                    exam.getCreatedAt(), exam.getUpdatedAt(),
                    exam.getCreateUser(), exam.getUpdateUser()
            );
        }
    }

    public record Search(String name) {
        public ExamCommand.Search toCommand() {
            return ExamCommand.Search.of(name);
        }
    }

}

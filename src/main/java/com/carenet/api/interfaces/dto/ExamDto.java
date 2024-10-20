package com.carenet.api.interfaces.dto;

import com.carenet.api.domain.exam.model.Exam;

public class ExamDto {

    public record Request(String name, int orders) {
        public Exam to() {
            return new Exam(this.name, this.orders);
        }
    }

    public record Response() {
    }
}

package com.carenet.exam.exam.dto.command;

public class ExamCommand {

    public record Search(String name) {
        public static Search of(String name) {
            return new Search(name);
        }
    }

    public record Create(String name, Integer orders) {
        public static Create of(String name, Integer orders) {
            return new Create(name, orders);
        }
    }

}

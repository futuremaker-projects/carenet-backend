package com.carenet.examapi.interfaces.dto;

import com.carenet.exam.exam.dto.command.ExamCommand;

public class SearchExamDto {

    public record Search(String name) {
        public static Search of(String name) {
            return new Search(name);
        }

        public ExamCommand.Search toCommand() {
            return ExamCommand.Search.of(name);
        }
    }

}

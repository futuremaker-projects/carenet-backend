package com.carenet.examapi.interfaces.dto;

import com.carenet.exam.cbt.dto.command.CbtCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class CbtDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Submit {
        private Long examId;                        // 모의고사 id
        private List<CbtDto.Answers> answers;       // 모의고사 답

        public CbtCommand.CreateSubmissions toCommand() {
            return CbtCommand.CreateSubmissions.of(
                    examId,
                    answers.stream()
                            .map(answer -> CbtCommand.Answers.of(answer.questionId, answer.answer))
                            .toList()
            );
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Answers {
        public Long questionId;
        public Integer answer;
    }
}

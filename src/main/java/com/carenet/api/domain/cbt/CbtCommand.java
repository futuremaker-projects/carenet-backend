package com.carenet.api.domain.cbt;

import java.util.List;

public class CbtCommand {

    public record Create(Long examId, List<CbtCommand.Answers> answers) {
        public static Create of(Long examId, List<Answers> answers) {
            return new Create(examId, answers);
        }
    }

    public record Answers(Long questionId, Integer answer) {
        public static Answers of(Long questionId, Integer answer) {
            return new Answers(questionId, answer);
        }
    }

    public record Submission(Long examId, Long questionId, Integer answer, Long userId) {
        public static Submission of(Long examId, Long questionId, Integer answer, Long userId) {
            return new Submission(examId, questionId, answer, userId);
        }
    }

}

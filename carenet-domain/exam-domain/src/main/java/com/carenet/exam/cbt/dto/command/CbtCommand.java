package com.carenet.exam.cbt.dto.command;

import com.carenet.exam.cbt.model.Submission;

import java.util.ArrayList;
import java.util.List;

public class CbtCommand {

    public record CreateSubmissions(Long examId, List<CbtCommand.Answers> answers) {
        public static CreateSubmissions of(Long examId, List<Answers> answers) {
            return new CreateSubmissions(examId, answers);
        }

        public List<Submission> toSubmissions(Long userId) {
            List<Submission> submissions = new ArrayList<>();
            answers.forEach(answer -> {
                Submission submission = Submission.of(examId(), answer.questionId(), answer.answer(), userId);
                submissions.add(submission);
            });
            return submissions;
        }
    }

    public record Answers(Long questionId, Integer answer) {
        public static Answers of(Long questionId, Integer answer) {
            return new Answers(questionId, answer);
        }
    }

}

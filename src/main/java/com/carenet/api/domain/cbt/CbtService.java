package com.carenet.api.domain.cbt;

import com.carenet.api.infrastructure.BulkInsertRepository;
import com.carenet.api.interfaces.cbt.dto.CbtDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CbtService {

    private final CbtRepository cbtRepository;
    private final BulkInsertRepository bulkInsertRepository;

    @Transactional
    public void saveCbtSubmission(CbtCommand.Create create, Long userId) {
        // 저장시 기존의 데이터를 지워야 함 / 복합키 구조임

        List<CbtCommand.Submission> submissions = new ArrayList<>();
        create.answers().forEach(answer -> {
            CbtCommand.Submission submission = CbtCommand.Submission.of(create.examId(), answer.questionId(), answer.answer(), userId);
            submissions.add(submission);
        });
        String query = "INSERT INTO submission (exam_id, question_id, user_id, answer) VALUES (?, ?, ? ,?)";
        bulkInsertRepository.bulkInsert(query, submissions,
                (ps, data) -> {
                    ps.setLong(1, data.examId());
                    ps.setLong(2, data.questionId());
                    ps.setLong(3, data.userId());
                    ps.setInt(4, data.answer());
                }
        );
    }
}

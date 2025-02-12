package com.carenet.storage.exam.repository.cbt;

import com.carenet.exam.cbt.CbtRepository;
import com.carenet.exam.cbt.model.Submission;
import com.carenet.storage.BulkInsertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CbtRepositoryImpl implements CbtRepository {

    private final BulkInsertRepository bulkInsertRepository;

    @Override
    public void deleteSubmissions(Long examId, Long userId) {

    }

    @Override
    public void saveSubmissions(List<Submission> submissions) {
        String query = "INSERT INTO submission (exam_id, question_id, user_id, answer) VALUES (?, ?, ? ,?)";
        bulkInsertRepository.bulkInsert(query, submissions,
                (ps, data) -> {
                    ps.setLong(1, data.getExamId());
                    ps.setLong(2, data.getQuestionId());
                    ps.setLong(3, data.getUserId());
                    ps.setInt(4, data.getAnswer());
                }
        );
    }
}

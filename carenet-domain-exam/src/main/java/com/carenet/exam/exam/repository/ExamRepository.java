package com.carenet.exam.exam.repository;

import com.carenet.exam.exam.dto.command.ExamCommand;
import com.carenet.exam.exam.model.Exam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface ExamRepository {

    Slice<Exam> getExams(Pageable pageable, ExamCommand.Search search);

    Exam save(ExamCommand.Create create);
    Long getTotalCount(ExamCommand.Search search);

}

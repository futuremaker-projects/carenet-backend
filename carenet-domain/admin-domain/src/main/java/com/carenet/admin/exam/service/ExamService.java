package com.carenet.admin.exam.service;

import com.carenet.admin.exam.dto.command.ExamCommand;
import com.carenet.admin.exam.model.Exam;
import com.carenet.admin.exam.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;

    public Slice<Exam> getExams(Pageable pageable, ExamCommand.Search search) {
        return examRepository.getExams(pageable, search);
    }

    public void createExam(ExamCommand.Create create) {
        examRepository.save(create);
    }

    public Long getTotalExamsCount(ExamCommand.Search search) {
        return examRepository.getTotalCount(search);
    }
}

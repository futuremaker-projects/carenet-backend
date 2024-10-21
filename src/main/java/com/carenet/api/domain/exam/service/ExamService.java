package com.carenet.api.domain.exam.service;

import com.carenet.api.domain.exam.repository.ExamRepository;
import com.carenet.api.interfaces.dto.ExamDto;
import com.carenet.api.interfaces.dto.SearchExamDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;

    public Slice<ExamDto.Response> getExams(Pageable pageable, SearchExamDto.GetExams search) {
        return examRepository.getExams(pageable, search).map(ExamDto.Response::of);
    }

    public void saveExam(ExamDto.Request requestDto) {
        examRepository.save(requestDto.to());
    }

    public Long getTotalExamsCount(SearchExamDto.GetExams search) {
        return examRepository.totalExamCount(search);
    }
}

package com.carenet.api.domain.exam.service;

import com.carenet.api.domain.exam.repository.ExamRepository;
import com.carenet.api.interfaces.dto.ExamDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;

    public void saveExam(ExamDto.Request requestDto) {
        examRepository.save(requestDto.to());
    }

}

package com.carenet.api.domain.exam.repository;

import com.carenet.api.domain.exam.model.Exam;
import com.carenet.api.interfaces.exam.dto.SearchExamDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface ExamRepository {

    Exam save(Exam exam);

    Slice<Exam> getExams(Pageable pageable, SearchExamDto.Search search);
    Long getTotalCount(SearchExamDto.Search search);

}

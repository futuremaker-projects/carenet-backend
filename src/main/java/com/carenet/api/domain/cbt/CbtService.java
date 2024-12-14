package com.carenet.api.domain.cbt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CbtService {

    private final CbtRepository cbtRepository;

    @Transactional
    public void saveCbtSubmissions(CbtCommand.CreateSubmissions createSubmissions, Long userId) {
        // 저장시 기존의 데이터를 지워야 함 / 복합키 구조
        // examId, userId 로 검색해서 삭제 필요
        deleteCbtSubmissions(createSubmissions.examId(), userId);
        cbtRepository.saveSubmissions(createSubmissions.toSubmissions(userId));
    }

    public void deleteCbtSubmissions(Long examId, Long userId) {
        cbtRepository.deleteSubmissions(examId, userId);
    }

}

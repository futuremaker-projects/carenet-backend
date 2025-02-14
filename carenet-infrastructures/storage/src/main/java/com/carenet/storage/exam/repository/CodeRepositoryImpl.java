package com.carenet.storage.exam.repository;

import com.carenet.admin.code.Code;
import com.carenet.admin.code.CodeRepository;
import com.carenet.storage.exam.mapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CodeRepositoryImpl implements CodeRepository {

    private final CodeJpaRepository codeJpaRepository;

    @Override
    public List<Code> findAllCodes(Long userId) {
        return codeJpaRepository.findByUserId(userId).stream()
                .map(ModelMapper.CodeMapper::from)
                .toList();
    }

}

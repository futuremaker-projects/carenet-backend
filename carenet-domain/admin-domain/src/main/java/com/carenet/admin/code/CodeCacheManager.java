package com.carenet.admin.code;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CodeCacheManager {

    private final CodeRepository codeRepository;

    public List<Code> getFlatCodes(Long userId) {
        return codeRepository.findAllCodes(userId);
    }

}

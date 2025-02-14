package com.carenet.admin.code;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeService {

    private final CodeCacheManager codeCacheManager;

    public List<Code> getCodes(Long userId) {
        return codeCacheManager.getFlatCodes(userId);
    }

}

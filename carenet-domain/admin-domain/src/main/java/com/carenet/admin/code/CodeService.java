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

    public List<Code> getHierarchyCodes(Long userId) {
        List<Code> codes = getCodes(userId);

        // 최상위 코드 모음
        List<Code> result = codes.stream()
                .filter(code -> code.getParentId() == null)
                .toList();
        addChildren(codes, result);

        return result;
    }

    public void addChildren(List<Code> codes, List<Code> result) {
        result.forEach(parent -> {
            codes.forEach(child -> {
                if (parent.getId().equals(child.getParentId())) {
                    parent.getChildren().add(child);
                }
            });
            if (!parent.getChildren().isEmpty()) {
                addChildren(codes, parent.getChildren());
            }
        });
    }
}

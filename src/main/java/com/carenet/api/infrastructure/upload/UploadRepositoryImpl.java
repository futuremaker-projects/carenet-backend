package com.carenet.api.infrastructure.upload;

import com.carenet.api.domain.upload.Upload;
import com.carenet.api.domain.upload.UploadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UploadRepositoryImpl implements UploadRepository {

    private final UploadJpaRepository uploadJpaRepository;

    @Override
    public Upload save(Upload upload) {
        UploadEntity uploadEntity = upload.toEntity();
        return uploadJpaRepository.save(uploadEntity).toDomain();
    }
}

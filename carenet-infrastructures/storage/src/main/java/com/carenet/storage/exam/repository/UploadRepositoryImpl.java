package com.carenet.storage.exam.repository;

import com.carenet.admin.upload.Upload;
import com.carenet.admin.upload.UploadRepository;
import com.carenet.admin.upload.dto.UploadCommand;
import com.carenet.storage.exam.entity.UploadEntity;
import com.carenet.storage.exam.mapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UploadRepositoryImpl implements UploadRepository {

    private final UploadJpaRepository uploadJpaRepository;

    @Override
    public Upload create(UploadCommand.Create create) {
        UploadEntity entity = UploadEntity.of(
                create.fileName(), create.storedName(), create.path(),
                create.contentType(), create.contentId(), create.contentCategory()
        );
        UploadEntity saved = uploadJpaRepository.save(entity);
        return ModelMapper.UploadMapper.from(saved);
    }
}

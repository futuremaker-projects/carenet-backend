package com.carenet.api.domain.upload;

import com.carenet.api.domain.upload.dto.EditorImageInfo;
import com.carenet.api.interfaces.upload.dto.UploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FileUploader {

    /**
     * - s3에 파일 업로드 하는거 해보자
     * - 썸네일 만드는 것도 해보면 좋은데...
     */

    @Value("${rootPath}")
    private String rootPath;
    @Value("${domain}")
    private String domain;

    private final UploadRepository uploadRepository;

    /**
     * 파일 저장 후 파일 자원 경로 url을 던진다.
     */
    public EditorImageInfo save(UploadDto.Save dto, MultipartFile file) throws MalformedURLException {
        String filePath = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDateTime.now());
        // 디렉토리 위치 - 년/월/일
        String fullPath = getFullPath(filePath);
        File rootDir = new File(fullPath);
        if (!rootDir.exists()) {
            try {
                rootDir.mkdirs();
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        String originalFilename = file.getOriginalFilename();
        String storedFileName = createStoredFileName(originalFilename);
        try {
            file.transferTo(new File(rootDir, storedFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Upload upload = Upload.builder()
                .fileName(originalFilename)
                .storedName(storedFileName)
                .path(filePath)
                .contentType(file.getContentType())
                .contentId(dto.contentId())
                .contentCategory(dto.contentCategory())
                .build();
        uploadRepository.save(upload);
        // domain + filePath + storedFilename
        String location = "%s/%s/%s".formatted(domain, filePath, storedFileName);

        return EditorImageInfo.of(location);
    }

    private String getFullPath(String fileName) {
        return rootPath + fileName;
    }

    private String createStoredFileName(String originalFilename) {
        String ext = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    private String extractExt(String originalFileName) {
        int delimiter = originalFileName.lastIndexOf(".");
        return originalFileName.substring(delimiter + 1);
    }
}

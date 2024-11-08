package com.carenet.api.interfaces.upload.dto;

import com.carenet.api.domain.upload.ContentCategory;
import com.carenet.api.domain.upload.dto.EditorImageInfo;

public class UploadDto {

    public record Save(
            Long id,
            String fileName,
            String storedName,
            String path,
            String contentType,
            Long contentId,
            ContentCategory contentCategory
    ) {

        public static Save of(Long contentId, ContentCategory contentCategory) {
            return new Save(null, null, null,
                    null, null, contentId, contentCategory);
        }
    }

    public record SendLocation(String location) {
        public static SendLocation of(String location) {
            return new SendLocation(location);
        }

        public static SendLocation from(EditorImageInfo info) {
            return SendLocation.of(info.getLocation());
        }
    }
}

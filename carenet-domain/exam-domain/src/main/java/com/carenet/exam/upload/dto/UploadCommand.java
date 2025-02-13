package com.carenet.exam.upload.dto;

import com.carenet.common.enums.ContentCategory;

public class UploadCommand {

    public record Create(
            String fileName,
            String storedName,
            String path,
            String contentType,
            Long contentId,
            ContentCategory contentCategory
    ) {
        public static Create of(Long contentId, ContentCategory contentCategory) {
            return new Create( null, null,
                    null, null, contentId, contentCategory);
        }

        public static Create of(String fileName, String storedName, String path, String contentType, Long contentId, ContentCategory contentCategory) {
            return new Create(fileName, storedName, path, contentType, contentId, contentCategory);
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

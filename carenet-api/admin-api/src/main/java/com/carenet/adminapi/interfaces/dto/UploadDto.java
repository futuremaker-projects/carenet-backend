package com.carenet.adminapi.interfaces.dto;

import com.carenet.admin.upload.dto.EditorImageInfo;
import com.carenet.admin.upload.dto.UploadCommand;
import com.carenet.common.enums.ContentCategory;

public class UploadDto {

    public record Save(Long contentId, ContentCategory contentCategory) {
        public static Save of(Long contentId, ContentCategory contentCategory) {
            return new Save(contentId, contentCategory);
        }

        public UploadCommand.Create toCommand() {
            return UploadCommand.Create.of(contentId, contentCategory);
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

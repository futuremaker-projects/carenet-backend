package com.carenet.exam.upload;

import com.carenet.common.enums.ContentCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Upload {

    private Long id;
    private String fileName;
    private String storedName;
    private String path;
    private String contentType;

    private Long contentId;
    private ContentCategory contentCategory;

    public static Upload of(Long id, String fileName, String storedName,
                     String path, String contentType, Long contentId,
                     ContentCategory contentCategory) {
        return new Upload(id, fileName, storedName, path, contentType, contentId, contentCategory);
    }

//    public UploadEntity toEntity() {
//        return UploadEntity.of(
//                fileName, storedName, path, contentType,
//                contentId, contentCategory
//        );
//    }

}

package com.carenet.api.infrastructure.upload;

import com.carenet.api.domain.upload.ContentCategory;
import com.carenet.api.domain.upload.Upload;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "upload",
        indexes = @Index(
                name = "idx_content_id_content_category",
                columnList = "contentId, contentCategory"
        ))
public class UploadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String fileName;

    @Column(length = 100)
    private String storedName;

    @Column(length = 100)
    private String contentType;

    @Column(length = 100)
    private String path;

    @Comment("컨텐츠 id")
    private Long contentId;

    @Column(columnDefinition = "varchar(20) NOT NULL COMMENT '컨텐츠 종류'")
    @Enumerated(value = EnumType.STRING)
    private ContentCategory contentCategory;

    @Builder
    public UploadEntity(Long id, String fileName, String storedName, String contentType, String path, Long contentId, ContentCategory contentCategory) {
        this.id = id;
        this.fileName = fileName;
        this.storedName = storedName;
        this.contentType = contentType;
        this.path = path;
        this.contentId = contentId;
        this.contentCategory = contentCategory;
    }

    public static UploadEntity of(String fileName, String storedName, String path, String contentType,
                                  Long contentId, ContentCategory contentCategory) {
        return UploadEntity.builder()
                .fileName(fileName)
                .storedName(storedName)
                .path(path)
                .contentType(contentType)
                .contentId(contentId)
                .contentCategory(contentCategory)
                .build();
    }

    public Upload toDomain() {
        return Upload.of(id, fileName, storedName, contentType, path, contentId, contentCategory);
    }
}

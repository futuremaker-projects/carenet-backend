package com.carenet.exam.upload.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EditorImageInfo {

    private String location;

    public EditorImageInfo(String location) {
        this.location = location;
    }

    public static EditorImageInfo of(String location) {
        return new EditorImageInfo(location);
    }

}

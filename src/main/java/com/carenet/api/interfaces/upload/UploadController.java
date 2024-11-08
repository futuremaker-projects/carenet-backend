package com.carenet.api.interfaces.upload;

import com.carenet.api.domain.upload.FileUploader;
import com.carenet.api.domain.upload.dto.EditorImageInfo;
import com.carenet.api.interfaces.upload.dto.UploadDto;
import com.carenet.api.support.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor
public class UploadController {

    private final FileUploader fileUploader;

    @PostMapping
    public Response<UploadDto.SendLocation> upload(
            @RequestPart(value = "file") MultipartFile file,
            @RequestPart(value = "requestDto") UploadDto.Save requestDto
    ) throws MalformedURLException {
        EditorImageInfo save = fileUploader.save(requestDto, file);
        return Response.success(UploadDto.SendLocation.from(save));
    }

}

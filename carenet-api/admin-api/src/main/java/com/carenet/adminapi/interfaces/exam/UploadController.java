package com.carenet.adminapi.interfaces.exam;

import com.carenet.admin.upload.FileUploader;
import com.carenet.admin.upload.dto.EditorImageInfo;
import com.carenet.adminapi.interfaces.dto.UploadDto;
import com.carenet.common.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/api/admin/upload")
@RequiredArgsConstructor
public class UploadController {

    private final FileUploader fileUploader;

    @PostMapping
    public Response<UploadDto.SendLocation> upload(
            @RequestPart(value = "file") MultipartFile file,
            @RequestPart(value = "requestDto") UploadDto.Save updateDto
    ) throws MalformedURLException {
        EditorImageInfo save = fileUploader.save(updateDto.toCommand(), file);
        return Response.success(UploadDto.SendLocation.from(save));
    }

}

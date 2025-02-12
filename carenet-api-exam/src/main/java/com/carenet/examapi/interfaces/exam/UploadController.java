package com.carenet.examapi.interfaces.exam;

import com.carenet.common.response.Response;
import com.carenet.exam.upload.FileUploader;
import com.carenet.exam.upload.dto.EditorImageInfo;
import com.carenet.examapi.interfaces.dto.UploadDto;
import lombok.RequiredArgsConstructor;
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
            @RequestPart(value = "requestDto") UploadDto.Save updateDto
    ) throws MalformedURLException {
        EditorImageInfo save = fileUploader.save(updateDto.toCommand(), file);
        return Response.success(UploadDto.SendLocation.from(save));
    }

}

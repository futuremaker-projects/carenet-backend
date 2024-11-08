package com.carenet.api.interfaces.upload;

import com.carenet.api.domain.upload.ContentCategory;
import com.carenet.api.domain.upload.FileUploader;
import com.carenet.api.domain.upload.dto.EditorImageInfo;
import com.carenet.api.interfaces.upload.dto.UploadDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UploadController.class)
class UploadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FileUploader fileUploader;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void given_when_then() throws Exception {
        // given
        Long contentId = 1L;
        ContentCategory contentCategory = ContentCategory.QUESTION;
        UploadDto.Save requestDto = UploadDto.Save.of(contentId, contentCategory);

        String convertedDto = objectMapper.writeValueAsString(requestDto);

        // 이미지 파일 업로드 테스트
//        ClassPathResource resource = new ClassPathResource("queue_test.png");
//        byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());
//
//        // 이미지 파일 mocking
//        MockMultipartFile imageFile = new MockMultipartFile(
//                "file",
//                "queue_test.png",
//                MediaType.IMAGE_PNG_VALUE,
//                imageBytes
//        );
        // 파일 생성
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "test-file.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Sample content".getBytes()
        );

        // dto mocking
        MockMultipartFile requestDtoPart = new MockMultipartFile(
                "requestDto",
                "",
                MediaType.APPLICATION_JSON_VALUE,
                convertedDto.getBytes()
        );

        Mockito.doReturn(EditorImageInfo.of("http://localhost:8080"))
                .when(fileUploader).save(Mockito.any(), Mockito.any());

        // when
        mockMvc.perform(multipart("/api/upload")
                .file(file)
                .file(requestDtoPart)
                .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk());
    }

}
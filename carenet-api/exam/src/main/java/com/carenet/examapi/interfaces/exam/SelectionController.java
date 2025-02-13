package com.carenet.examapi.interfaces.exam;

import com.carenet.common.response.Response;
import com.carenet.exam.exam.service.SelectionService;
import com.carenet.examapi.interfaces.dto.SelectionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/selections")
@RequiredArgsConstructor
public class SelectionController {

    private final SelectionService selectionService;

    @PutMapping
    public Response<Void> updateSelection(@RequestBody SelectionDto.RequestUpdate requestUpdate) {
        selectionService.updateSelection(requestUpdate.toCommand());
        return Response.success();
    }

}

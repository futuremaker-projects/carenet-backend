package com.carenet.api.interfaces.exam;

import com.carenet.api.domain.exam.service.SelectionService;
import com.carenet.api.interfaces.exam.dto.SelectionDto;
import com.carenet.api.support.response.Response;
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
    public Response<Void> updateSelection(@RequestBody SelectionDto.Request request) {
        selectionService.updateSelection(request.toDomain());
        return Response.success();
    }

}

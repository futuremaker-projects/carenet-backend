package com.carenet.adminapi.interfaces.exam;

import com.carenet.admin.exam.service.SelectionService;
import com.carenet.adminapi.interfaces.dto.SelectionDto;
import com.carenet.common.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/selections")
@RequiredArgsConstructor
public class SelectionController {

    private final SelectionService selectionService;

    @PutMapping
    public Response<Void> updateSelection(@RequestBody SelectionDto.Update updateDto) {
        selectionService.updateSelection(updateDto.toCommand());
        return Response.success();
    }

}

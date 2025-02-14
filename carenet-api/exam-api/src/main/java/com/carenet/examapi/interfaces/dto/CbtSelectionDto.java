package com.carenet.examapi.interfaces.dto;

import com.carenet.exam.cbt.dto.command.CbtSelectionCommand;
import com.carenet.exam.cbt.model.CbtSelection;

import java.time.LocalDateTime;

public class CbtSelectionDto {

    public record Response(Long questionId,
                           Long selectionId,
                           String content,
                           LocalDateTime createdAt,
                           LocalDateTime updatedAt
    ) {

        public static Response of(Long questionId, Long selectionId, String content,
                                  LocalDateTime createdAt, LocalDateTime updatedAt) {
            return new Response(questionId, selectionId, content, createdAt, updatedAt);
        }

        public static Response from(CbtSelection cbtSelection) {
            return Response.of(
                    cbtSelection.getQuestionId(), cbtSelection.getSelectionId(), cbtSelection.getContent(),
                    cbtSelection.getCreatedAt(), cbtSelection.getUpdatedAt()
            );
        }

    }

    public record Update(Long questionId, Long selectionId, String content) {
        public static Update of(Long questionId, Long selectionId, String content) {
            return new Update(questionId, selectionId, content);
        }

        public CbtSelectionCommand.Update toCommand() {
            return CbtSelectionCommand.Update.of(questionId, selectionId, content);
        }
    }

}

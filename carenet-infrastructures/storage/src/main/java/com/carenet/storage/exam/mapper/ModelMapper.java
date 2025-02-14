package com.carenet.storage.exam.mapper;

import com.carenet.admin.code.Code;
import com.carenet.admin.exam.model.Exam;
import com.carenet.admin.exam.model.Question;
import com.carenet.admin.exam.model.Selection;
import com.carenet.admin.upload.Upload;
import com.carenet.storage.exam.entity.CodeEntity;
import com.carenet.storage.exam.entity.UploadEntity;
import com.carenet.storage.exam.entity.exam.ExamEntity;
import com.carenet.storage.exam.entity.exam.QuestionEntity;
import com.carenet.storage.exam.entity.exam.SelectionEntity;

/**
    entity를 기준으로
 */
public class ModelMapper {

    public record ExamMapper() {
        public static Exam from(ExamEntity examEntity) {
            return Exam.of(examEntity.getId(), examEntity.getName(), examEntity.getOrders(),
                    examEntity.getProgressType(), examEntity.getCreatedAt(), examEntity.getUpdatedAt());
        }
    }

    public record QuestionMapper() {
        public static Question from(QuestionEntity questionEntity) {
            return Question.of(
                    questionEntity.getId(), questionEntity.getName(), questionEntity.getExamId(),
                    questionEntity.getCodeId(), questionEntity.getArticle(), questionEntity.getAnswer()
            );
        }
    }

    public record SelectionMapper() {
        public static Selection from(SelectionEntity selectionEntity) {
            return Selection.of(
                    selectionEntity.getId().getQuestionId(), selectionEntity.getId().getSelectionId(),
                    selectionEntity.getContent()
            );
        }
    }

    public record UploadMapper() {
        public static Upload from(UploadEntity uploadEntity) {
            return Upload.of(
                    uploadEntity.getId(), uploadEntity.getFileName(), uploadEntity.getStoredName(),
                    uploadEntity.getPath(), uploadEntity.getContentType(), uploadEntity.getContentId(),
                    uploadEntity.getContentCategory()
            );
        }
    }

    public record CodeMapper() {
        public static Code from(CodeEntity codeEntity) {
            return Code.of(
                    codeEntity.getId(), codeEntity.getName(), codeEntity.getParentId(),
                    codeEntity.getUserId(), codeEntity.getOrders(), codeEntity.getQuestionCount()
            );
        }
    }

}

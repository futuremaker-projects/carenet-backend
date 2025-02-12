package com.carenet.exam.upload;

import com.carenet.exam.upload.dto.UploadCommand;

public interface UploadRepository {

    Upload create(UploadCommand.Create create);

}

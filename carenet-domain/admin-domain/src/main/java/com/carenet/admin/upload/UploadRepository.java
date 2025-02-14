package com.carenet.admin.upload;

import com.carenet.admin.upload.dto.UploadCommand;

public interface UploadRepository {

    Upload create(UploadCommand.Create create);

}

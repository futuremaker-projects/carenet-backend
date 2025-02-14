package com.carenet.admin.exam.repository;

import com.carenet.admin.exam.dto.command.SelectionCommand;
import com.carenet.admin.exam.model.Selection;

public interface SelectionRepository {

    Selection getSelection(SelectionCommand.Get get);

    Selection save(SelectionCommand.Create create);

    void updateContent(SelectionCommand.Update update);

}

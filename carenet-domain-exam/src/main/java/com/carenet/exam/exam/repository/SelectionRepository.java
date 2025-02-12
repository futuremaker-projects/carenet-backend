package com.carenet.exam.exam.repository;

import com.carenet.exam.exam.dto.command.SelectionCommand;
import com.carenet.exam.exam.model.Selection;

public interface SelectionRepository {

    Selection getSelection(SelectionCommand.Get get);

    Selection save(SelectionCommand.Create create);

    void updateContent(SelectionCommand.Update update);

}

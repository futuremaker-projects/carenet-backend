package com.carenet.api.domain.exam.repository;

import com.carenet.api.domain.exam.model.Selection;

public interface SelectionRepository {

    Selection save(Selection selection);

    void updateSelection(Selection selection);

}

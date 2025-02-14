package com.carenet.exam.cbt;

import com.carenet.exam.cbt.dto.command.CbtQuestionCommand;
import com.carenet.exam.cbt.model.CbtQuestion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CbtQuestionService {

    private final CbtQuestionRepository cbtQuestionRepository;

    public List<CbtQuestion> getCbtQuestions(CbtQuestionCommand.Get get) {
        return cbtQuestionRepository.getCbtQuestions(get);
    }
}

package com.example.slackpool.application;

import com.example.slackpool.domain.YesNoQuestion;
import com.example.slackpool.infrastructure.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuestionnaireService {

    private final QuestionRepository questionRepository;

    public YesNoQuestion create(CreateQuestionnaireCommand command) {
        var question = new YesNoQuestion(command);
        return questionRepository.save(question);
    }

}

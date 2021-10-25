package com.example.slackpool.application;

import com.example.slackpool.domain.YesNoQuestion;
import com.example.slackpool.infrastructure.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class QuestionnaireService {

    private final QuestionRepository questionRepository;

    public YesNoQuestion create(CreateQuestionnaireCommand command) {
        var existingQuestion = questionRepository.findByQuestionAndEndTime(command.getQuestion(), null);
        if (existingQuestion.isPresent())
            throw new IllegalStateException();

        var question = new YesNoQuestion(command);
        return questionRepository.save(question);
    }

    public YesNoQuestion end(String questionString) {
        var question = questionRepository.findByQuestionAndEndTime(questionString, null)
                .orElseThrow(IllegalStateException::new);
        question.end();
        return questionRepository.save(question);
    }

}

package com.example.slackpool.client;

import com.example.slackpool.application.CreateQuestionnaireCommand;
import com.example.slackpool.application.QuestionnaireService;
import com.example.slackpool.domain.User;
import com.slack.api.bolt.App;
import com.slack.api.bolt.context.builtin.SlashCommandContext;
import com.slack.api.bolt.request.builtin.SlashCommandRequest;
import com.slack.api.bolt.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SlackCommandsController {
    @Autowired
    private App slackApp;

    @Autowired
    private QuestionnaireService questionnaireService;

    @PostConstruct
    public void init() {
        slackApp.command("/question", this::createQuestionnaire);
    }

    Response createQuestionnaire(SlashCommandRequest req, SlashCommandContext context) {
        var question = questionnaireService.create(CreateQuestionnaireCommand.builder()
                .question(req.getPayload().getText())
                .author(new User(req.getPayload().getUserId(), req.getPayload().getUserName()))
                .build());
        return context.ack("Created questionnaire " + question.getQuestion() + " " + question.getAnswerSummary());
    }
}

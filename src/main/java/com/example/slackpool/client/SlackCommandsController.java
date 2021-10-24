package com.example.slackpool.client;

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

    @PostConstruct
    public void init() {
        slackApp.command("/question2", this::question2);
    }

    Response question2(SlashCommandRequest req, SlashCommandContext context) {
        return context.ack(":wave: Hello World!");
    }
}

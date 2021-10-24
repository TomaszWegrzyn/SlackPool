package com.example.slackpool.config;

import com.slack.api.bolt.App;
import com.slack.api.bolt.socket_mode.SocketModeApp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackApp {
    @Bean
    public SocketModeApp initSlackApp() throws Exception {
        var app = new App();
        app.command("/question2", (req, ctx) -> {
                return ctx.ack(":wave: Hello!");
            }
        );
        var sapp = new SocketModeApp(app);
        sapp.start();
        return sapp;
    }
}
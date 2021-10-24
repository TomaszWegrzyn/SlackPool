package com.example.slackpool.config;

import com.slack.api.bolt.App;
import com.slack.api.bolt.socket_mode.SocketModeApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackAppConfig {
    @Bean
    public App slackBoltApp() {
        return new App();
    }

    @Bean
    public SocketModeApp socketModeApp(App slackBoltApp) throws Exception {
        var app = new SocketModeApp(slackBoltApp);
        app.startAsync();
        return app;
    }
}
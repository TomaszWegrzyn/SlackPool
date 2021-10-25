package com.example.slackpool.application;

import com.example.slackpool.domain.User;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateQuestionnaireCommand {

    private final User author;
    private final String question;

}

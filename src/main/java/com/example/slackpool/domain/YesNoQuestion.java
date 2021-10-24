package com.example.slackpool.domain;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.Set;

@Value
public class YesNoQuestion {

    private final User author;
    private final LocalDateTime creationTime;
    private final LocalDateTime endTime;
    private final String question;
    private final Set<Answer> answers;

}

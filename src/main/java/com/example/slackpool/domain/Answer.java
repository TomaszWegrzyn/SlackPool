package com.example.slackpool.domain;

import lombok.Value;

@Value
public class Answer {

    private final User answerer;
    private final boolean answer;

}

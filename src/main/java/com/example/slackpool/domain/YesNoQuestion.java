package com.example.slackpool.domain;

import com.example.slackpool.application.CreateQuestionnaireCommand;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "questions")
public class YesNoQuestion {

    @Id
    private UUID id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User author;
    private LocalDateTime creationTime;
    private LocalDateTime endTime;
    private String question;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question")
    private Set<Answer> answers;

    public YesNoQuestion(CreateQuestionnaireCommand command) {
        this.id = UUID.randomUUID();
        this.author = command.getAuthor();
        this.creationTime = LocalDateTime.now();
        this.endTime = null;
        this.question = command.getQuestion();
        this.answers = null;
    }

    public String getAnswerSummary() {
        int pros = 0;
        int cons = 0;
        if (answers != null)
            for (Answer a : answers) {
                if (a.isAnswer())
                    pros += 1;
                else cons += 1;
            }
        return "Pros: " + pros + ", cons:" + cons;
    }

    public void end() {
        this.endTime = LocalDateTime.now();
    }
}

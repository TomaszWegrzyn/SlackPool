package com.example.slackpool.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "answers")
@IdClass(AnswerPK.class)
public class Answer {

    @Id
    @ManyToOne
    @JoinColumn(name = "answerer_id", referencedColumnName = "id")
    private User answerer;
    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private YesNoQuestion question;

    private boolean answer;

}

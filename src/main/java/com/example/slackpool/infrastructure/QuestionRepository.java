package com.example.slackpool.infrastructure;

import com.example.slackpool.domain.YesNoQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<YesNoQuestion, UUID> {

    Optional<YesNoQuestion> findByQuestionAndEndTime(String question, LocalDateTime endTime);

}

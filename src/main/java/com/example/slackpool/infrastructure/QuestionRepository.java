package com.example.slackpool.infrastructure;

import com.example.slackpool.domain.YesNoQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<YesNoQuestion, UUID> {
}

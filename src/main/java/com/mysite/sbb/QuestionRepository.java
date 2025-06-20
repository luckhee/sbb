package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Optional<Question> findBySubject(String subject);

    Optional<Question> findBySubjectAndContent(String s, String s1);

    Optional<Question> findBySubjectLike(String subjectLike);

}


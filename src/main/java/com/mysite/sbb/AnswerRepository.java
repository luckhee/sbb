package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Question, Integer> {
}

package com.mysite.sbb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ActiveProfiles("test")
@SpringBootTest
@Transactional
class PostRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    @DisplayName("수정")
    void t0() {
        Optional<Question> op = questionRepository.findById(1);

        Question q = op.get();
        q.setSubject("수정된 제목");
        questionRepository.save(q);

        Question op1 = questionRepository.findById(1).get();
        assertThat(op1.getSubject()).isEqualTo("수정된 제목");
    }

    @Test
    @DisplayName("findAll")
    void t1() {
        List<Question> all = questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertThat(q.getSubject()).isEqualTo("sbb가 무엇인가요?");
        assertThat(q.getContent()).isEqualTo("sbb에 대해서 알고 싶습니다.");
    }

    @Test
    @DisplayName("findById")
    void t2() {
        Optional<Question> op = questionRepository.findById(1);

        Question q = op.get();
        assertThat(q.getSubject()).isEqualTo("sbb가 무엇인가요?");
    }

    @Test
    @DisplayName("findBySubject")
    void t3() {
        Optional<Question> op = questionRepository.findBySubject("sbb가 무엇인가요?");

        Question q = op.get();
        assertThat(q.getSubject()).isEqualTo("sbb가 무엇인가요?");
    }

    @Test
    @DisplayName("findBySubjectAndContent")
    void t4() {
        Optional<Question> op = questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");

        Question q = op.get();
        assertThat(q.getSubject()).isEqualTo("sbb가 무엇인가요?");
        assertThat(q.getContent()).isEqualTo("sbb에 대해서 알고 싶습니다.");
    }

    @Test
    @DisplayName("findBySubjectLike(String subject)")
    void t5() {
        Optional<Question> op = questionRepository.findBySubjectLike("sbb%");

        Question q = op.get();
        assertThat(q.getSubject()).isEqualTo("sbb가 무엇인가요?");
        assertThat(q.getContent()).isEqualTo("sbb에 대해서 알고 싶습니다.");
    }
}

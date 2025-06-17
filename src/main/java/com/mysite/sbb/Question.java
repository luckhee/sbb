package com.mysite.sbb;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private LocalDateTime createDate;

    @Column(length =200)
    private String subject;

    @Column(columnDefinition ="TEXT")
    private String content;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answer; //answer_ids 같은 테이블은 생기지 않는다. 왜냐면 디비는 중복 허용안하고 제1정규화

}

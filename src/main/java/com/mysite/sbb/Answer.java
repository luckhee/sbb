package com.mysite.sbb;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private LocalDateTime createDate;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    private Question question; //Question_id
}

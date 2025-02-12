package com.example.schedulemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "schedule")
public class Schedule extends DateEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;

    public Schedule(String title, String task) {
        this.title = title;
        this.task = task;
    }

    public Schedule(String title, String task, User user) {
        this.title = title;
        this.task = task;
        this.user = user;
    }

    // 일정 수정
    public void update(String title, String task) {
        this.title = title;
        this.task = task;
    }
}

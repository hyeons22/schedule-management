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
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String task;

    public Schedule(String name, String title, String task) {
        this.name = name;
        this.title = title;
        this.task = task;
    }

    // 일정 수정
    public void update(String name, String title, String task) {
        this.name = name;
        this.title = title;
        this.task = task;
    }
}

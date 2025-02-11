package com.example.schedulemanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String title;
    private String task;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public Schedule(String name, String title, String task, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.name = name;
        this.title = title;
        this.task = task;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}

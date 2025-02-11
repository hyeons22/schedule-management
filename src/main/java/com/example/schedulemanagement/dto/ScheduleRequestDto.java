package com.example.schedulemanagement.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private final String name;
    private final String title;
    private final String task;

    public ScheduleRequestDto(String name, String title, String task) {
        this.name = name;
        this.title = title;
        this.task = task;
    }
}

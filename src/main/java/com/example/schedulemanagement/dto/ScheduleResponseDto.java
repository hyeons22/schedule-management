package com.example.schedulemanagement.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final String name;
    private final String title;
    private final String task;

    public ScheduleResponseDto(Long id, String name, String title, String task) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.task = task;
    }
}

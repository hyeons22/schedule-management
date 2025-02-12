package com.example.schedulemanagement.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private final String name;
    private final String password;

    public SignUpRequestDto(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

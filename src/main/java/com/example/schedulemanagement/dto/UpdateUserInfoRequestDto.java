package com.example.schedulemanagement.dto;

import lombok.Getter;

@Getter
public class UpdateUserInfoRequestDto {

    private final String name;
    private final String password;

    public UpdateUserInfoRequestDto(String name, String password) {
        this.name = name;
        this.password = password;
    }




}

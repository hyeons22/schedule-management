package com.example.schedulemanagement.controller;

import com.example.schedulemanagement.dto.UserRequestDto;
import com.example.schedulemanagement.dto.UserResponseDto;
import com.example.schedulemanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 생성
    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> save(@RequestBody UserRequestDto requestDto){
        return ResponseEntity.ok(userService.save(requestDto));
    }

}

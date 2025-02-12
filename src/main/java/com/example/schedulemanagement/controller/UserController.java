package com.example.schedulemanagement.controller;

import com.example.schedulemanagement.dto.*;
import com.example.schedulemanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 생성
    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> save(@RequestBody UserRequestDto requestDto){
        return ResponseEntity.ok(userService.save(requestDto));
    }

    // 유저 전체 조회
    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
    
    // 유저 단건 조회
    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.findById(userId));
    }

    // 유저 정보 수정
    @PutMapping("/users/{userId}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long userId, @RequestBody UserRequestDto requestDto){
        return ResponseEntity.ok(userService.update(userId, requestDto));
    }

    // 유저 삭제
    @DeleteMapping("/users/{userId}")
    public void deleteById(@PathVariable Long userId){
        userService.deleteById(userId);
    }


}

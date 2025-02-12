package com.example.schedulemanagement.controller;

import com.example.schedulemanagement.dto.*;
import com.example.schedulemanagement.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입(유저 생성)
    @PostMapping("/users/signup")
    public ResponseEntity<UserResponseDto> signUp(@RequestBody SignUpRequestDto requestDto){
        return ResponseEntity.ok(userService.signUp(requestDto));
    }

    // 세션을 받아오기 위한 로그인
    @PostMapping("/users/login")
    public ResponseEntity<UserResponseDto> login(@RequestBody LoginRequestDto requestDto, HttpServletRequest httpServletRequest){
        return ResponseEntity.ok(userService.login(requestDto,httpServletRequest));

    }

    // 유저 전체 조회
    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
    
    // 유저 단건 조회
    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long userId, HttpServletRequest httpServletRequest){
        return ResponseEntity.ok(userService.findById(userId, httpServletRequest.getSession()));
    }

    // 유저 정보 수정
    @PutMapping("/users/{userId}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long userId, @RequestBody UpdateUserInfoRequestDto requestDto, HttpServletRequest httpServletRequest){
        return ResponseEntity.ok(userService.update(userId, requestDto, httpServletRequest.getSession()));
    }

    // 유저 삭제
    @DeleteMapping("/users/{userId}")
    public void deleteById(@PathVariable Long userId, HttpServletRequest httpServletRequest){
        userService.deleteById(userId, httpServletRequest.getSession());
    }


}

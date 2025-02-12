package com.example.schedulemanagement.service;

import com.example.schedulemanagement.dto.UserRequestDto;
import com.example.schedulemanagement.dto.UserResponseDto;
import com.example.schedulemanagement.entity.User;
import com.example.schedulemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 유저 생성
    @Transactional
    public UserResponseDto save(UserRequestDto requestDto) {
        User user = new User(requestDto.getName(), requestDto.getEmail());
        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }
}

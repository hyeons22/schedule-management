package com.example.schedulemanagement.service;

import com.example.schedulemanagement.dto.UserRequestDto;
import com.example.schedulemanagement.dto.UserResponseDto;
import com.example.schedulemanagement.entity.User;
import com.example.schedulemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    // 유저 전체 조회
    @Transactional(readOnly = true)
    public List<UserResponseDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserResponseDto> dtoList = new ArrayList<>();

        for (User user : users) {
            UserResponseDto userResponseDto = new UserResponseDto(user.getId(), user.getName(), user.getEmail());
            dtoList.add(userResponseDto);
        }
        return dtoList;
    }

    // 유저 단건 조회
    @Transactional(readOnly = true)
    public UserResponseDto findById(Long userId) {
        User user = userRepository.findByIdOrElseThrow(userId);
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    // 유저 정보 수정
    @Transactional
    public UserResponseDto update(Long userId, UserRequestDto requestDto) {
        User user = userRepository.findByIdOrElseThrow(userId);
        user.update(requestDto.getName(), requestDto.getEmail());

        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    // 유저 삭제
    @Transactional
    public void deleteById(Long userId) {
        User findUser = userRepository.findByIdOrElseThrow(userId);
        userRepository.deleteById(userId);
    }
}

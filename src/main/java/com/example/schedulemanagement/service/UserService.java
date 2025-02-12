package com.example.schedulemanagement.service;

import com.example.schedulemanagement.dto.*;
import com.example.schedulemanagement.entity.User;
import com.example.schedulemanagement.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 회원가입(유저 생성)
    @Transactional
    public UserResponseDto signUp(SignUpRequestDto requestDto) {
        User user = new User(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword());
        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }

    // 로그인
    public UserResponseDto login(LoginRequestDto requestDto, HttpServletRequest httpServletRequest) {
        User findUser = userRepository.findByEmailOrElseThrow(requestDto.getEmail());

        // 비밀번호가 일치하는지 확인
        if(!requestDto.getPassword().equals(findUser.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("login", findUser);

        return new UserResponseDto(findUser.getId(), findUser.getName(), findUser.getEmail());

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
    public UserResponseDto findById(Long userId, HttpSession session) {
        User login = (User) session.getAttribute("login");
        if(!(userId == login.getId())){
            throw new IllegalArgumentException("아이디가 일치하지 않습니다.");
        }
        User findUser = userRepository.findByIdOrElseThrow(userId);
        return new UserResponseDto(findUser.getId(), findUser.getName(), findUser.getEmail());
    }

    // 유저 정보 수정
    @Transactional
    public UserResponseDto update(Long userId, UpdateUserInfoRequestDto requestDto, HttpSession session) {
        User login = (User) session.getAttribute("login");
        if(!(userId == login.getId())){
            throw new IllegalArgumentException("아이디가 일치하지 않습니다.");
        }
        User findUser = userRepository.findByIdOrElseThrow(userId);

        findUser.update(requestDto.getName(), requestDto.getPassword());

        return new UserResponseDto(findUser.getId(), findUser.getName(), findUser.getEmail());
    }

    // 유저 삭제
    @Transactional
    public void deleteById(Long userId, HttpSession session) {
        // 유저가 알맞은 요청을 했으면 session 삭제
        User login = (User) session.getAttribute("login");
        if(!(userId == login.getId())){
            throw new IllegalArgumentException("아이디가 일치하지 않습니다.");
        }
        session.invalidate();

        User findUser = userRepository.findByIdOrElseThrow(userId);
        userRepository.deleteById(findUser.getId());
    }



}

package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    default User findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(
                () -> new IllegalArgumentException("id에 맞는 유저가 없습니다.")
        );
    }

    Optional<Object> findByEmail(String email);

    default User findByEmailOrElseThrow(String email){
        return (User) findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("id에 맞는 이메일이 없습니다.")
        );
    }


}

package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    default User findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(
                () -> new IllegalArgumentException("id에 맞는 유저가 없습니다.")
        );
    }
}

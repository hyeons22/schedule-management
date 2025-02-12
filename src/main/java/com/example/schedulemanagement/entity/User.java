package com.example.schedulemanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User extends DateEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false , unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }



    // 유저 수정
    public void update(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // 회원 가입
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

    }
}

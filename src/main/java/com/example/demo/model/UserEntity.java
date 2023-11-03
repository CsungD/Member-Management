package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Members")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false, unique = true)
    private String id;
    @Column(nullable = false)
    private String pw;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String nick;

    public void changeNickAndPw(String nick,String pw){
        this.pw = pw;
        this.nick = nick;
    }
}

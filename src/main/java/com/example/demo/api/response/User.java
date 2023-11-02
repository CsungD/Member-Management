package com.example.demo.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class User {
    private  Long no;
    private final String id;
    private final String pw;
    private final String name;
    private final String nick;
    private final ZonedDateTime createAt;
    private final ZonedDateTime updateAt;
}

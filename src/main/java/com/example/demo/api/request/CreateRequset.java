package com.example.demo.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class CreateRequset {
    private String user;
    private String pw;
    private String name;
    private String nick;
}

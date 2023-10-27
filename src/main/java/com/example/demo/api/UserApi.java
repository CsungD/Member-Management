package com.example.demo.api;

import com.example.demo.api.request.CreateRequset;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;
    @PostMapping("/user/create")
    public void createUser(
        @RequestBody CreateRequset createRequset){
        userService.createUser(createRequset);
    }

}

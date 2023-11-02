package com.example.demo.api;

import com.example.demo.api.request.CreateRequset;
import com.example.demo.api.response.User;
import com.example.demo.model.UserEntity;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;
    @PostMapping("/user/create")
    public void createUser(
        @RequestBody CreateRequset createRequset){
        userService.createUser(createRequset);
    }

    @DeleteMapping("/user/delect/{id}/{pw}")
    public void delectUser(
            @PathVariable String id,
            @PathVariable  String pw
    ){
        userService.deleteUser(id,pw);
    }

    @GetMapping("/user/findId/{name}")
    public UserEntity findUserId(
            @PathVariable String name
    ){
       return userService.findByUserId(name);

    }

    @GetMapping("/user/findPw/{id}/{name}")
    public UserEntity findUserPw(
            @PathVariable String id,
            @PathVariable  String name
    ){
        return userService.findPwByIdAndName(id, name);
    }

    @PutMapping("/user/change/{no}")
    public void changeNickAndPw(
            @PathVariable Long no,
            @RequestBody CreateRequset createRequset
    ){
        userService.changeNickAndPw(no, createRequset);
    }
}

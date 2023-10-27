package com.example.demo.service;

import com.example.demo.api.request.CreateRequset;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserEntity createUser(
        CreateRequset createRequset
    ){
        UserEntity userEntity = UserEntity.builder()
                .users(createRequset.getUser())
                .pw(createRequset.getPw())
                .name(createRequset.getName())
                .nick(createRequset.getNick())
                .createAt(ZonedDateTime.now())
                .updateAt(ZonedDateTime.now())
                .build();

        userRepository.save(userEntity);

        return userEntity;
    }

}
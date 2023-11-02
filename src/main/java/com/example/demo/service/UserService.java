package com.example.demo.service;

import com.example.demo.api.request.CreateRequset;
import com.example.demo.api.response.User;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
                .id(createRequset.getId())
                .pw(createRequset.getPw())
                .name(createRequset.getName())
                .nick(createRequset.getNick())
                .createAt(ZonedDateTime.now())
                .updateAt(ZonedDateTime.now())
                .build();

        userRepository.save(userEntity);

        return userEntity;
    }

    @Transactional
    public void deleteUser(
            String id,String pw
    ){
        UserEntity userEntity = userRepository.findByIdAndPw(id, pw);
        userRepository.delete(userEntity);
    }

    public UserEntity findByUserId(String name)   {

        UserEntity userEntity = userRepository.findByName(name);
        return UserEntity.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .build();
                
    }

    public UserEntity findPwByIdAndName(String id, String name){

        UserEntity userEntity = userRepository.findPwByIdAndName(id,name);
        return UserEntity.builder()
                .id(userEntity.getId())
                .pw(userEntity.getPw())
                .name(userEntity.getName())
                .build();
    }

    public void changeNickAndPw(
            Long no,
            CreateRequset createRequset
    ){
        UserEntity userEntity = userRepository.findById(no).orElseThrow(()->new RuntimeException("나타나지않습니다."));
        userEntity.changeNickAndPw(createRequset.getNick(), createRequset.getPw());
        userRepository.save(userEntity);
    }
}

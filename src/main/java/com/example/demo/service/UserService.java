package com.example.demo.service;


import com.example.demo.api.request.MemberRequset;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserEntity createUser(
        MemberRequset member
    ){
        UserEntity userEntity = UserEntity.builder()
                .id(member.getId())
                .pw(member.getPw())
                .name(member.getName())
                .nick(member.getNick())
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

        UserEntity userEntity = userRepository.findIdByName(name);
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
            MemberRequset member
    ){
        UserEntity userEntity = userRepository.findById(no).orElseThrow(()->new RuntimeException("나타나지않습니다."));
        userEntity.changeNickAndPw(member.getNick(), member.getPw());
        userRepository.save(userEntity);
    }
}

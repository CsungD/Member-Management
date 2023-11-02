package com.example.demo.repository;

import com.example.demo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserEntity, Long> {

    UserEntity findByIdAndPw(String id,String pw);

    UserEntity findByName(String name);
    UserEntity findPwByIdAndName(String id,String name);

}

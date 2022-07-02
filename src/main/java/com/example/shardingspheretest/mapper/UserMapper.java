package com.example.shardingspheretest.mapper;

import com.example.shardingspheretest.entity.User;

import java.util.List;


public interface UserMapper {
    List<User> selectUserList();

    void insertUser(User user);


}


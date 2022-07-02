package com.example.shardingspheretest;

import com.example.shardingspheretest.entity.User;
import com.example.shardingspheretest.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingsphereTestApplicationTests {

    /*@Autowired
    private UserMapper userMapper;

    @Test
    void inserUser() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setAge(18);
            user.setName("张山" + i);
            user.setEmail(i + "1234567@qq.com");
            userMapper.insert(user);
        }
    }*/

}

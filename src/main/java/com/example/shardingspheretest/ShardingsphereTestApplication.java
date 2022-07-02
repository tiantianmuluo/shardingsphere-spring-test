package com.example.shardingspheretest;

import com.example.shardingspheretest.entity.User;
import com.example.shardingspheretest.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@SpringBootApplication
@MapperScan("com.example.shardingspheretest.mapper")
public class ShardingsphereTestApplication {

    @Autowired
    private UserMapper userMapper;

    @Resource(name = "testJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/getUserList")
    public String getUserList() {
        List<User> users = userMapper.selectUserList();
        System.out.println("用户信息：" + users.toString());
        return "OK";
    }

    @GetMapping("/addUserList")
    public String addUserList() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
//            user.setId(Long.valueOf(i));
            user.setAge(18);
            user.setName("张山" + i);
            user.setEmail(i + "1234567@qq.com");
            userMapper.insertUser(user);
        }
        return "OK";
    }

    @GetMapping("/selectUserList")
    public String selectUserList() {
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("use `db-0`;");
//        stringBuffer.append("select * from user_0;");
//        stringBuffer.append("select count(1) from user_0;");
//        String sql = stringBuffer.toString();
        Integer integer = jdbcTemplate.queryForObject("select count(1) from user_0", Integer.class);
//        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
//        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
//        System.out.println("用户信息：" + users.toString());
        System.out.println("用户信息：" + integer.toString());
        return "OK";
    }

    public static void main(String[] args) {
        SpringApplication.run(ShardingsphereTestApplication.class, args);
    }

}

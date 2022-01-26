package com.example.demo.config;

import com.example.demo.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestUserConfig {
//    指定装配配置文件
    @Bean("user")
    public User getUser(){
        User user = new User();
        user.setId(10086);
        return user;
    }
}

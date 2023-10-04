package com.example.demo;

import com.example.demo.pojo.User;
import com.example.demo.service.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest
class DemoApplicationTests {

    @Resource
    private UserServiceImpl userService;
    @Test
    void contextLoads() {
//        这是一个对于 service 层 checkPassword 方法的测试
        User user = new User("admin", "passw0rd");
//        passw0rd 的 SHA256 结果 => 8f0e2f76e22b43e2855189877e7dc1e1e7d98c226c95db247cd1d547928334a9
        System.out.println(userService.checkPassword(user));
    }

}

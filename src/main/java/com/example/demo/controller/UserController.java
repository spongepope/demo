package com.example.demo.controller;


import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController {
    //  这里跟使用 @Autowire 注解是一样的效果
    //  自动装配名为 UserService 的 bean
    @Resource
    private UserService userService;

    //  这是实现登录的接口
    //  这里使用 PostMapping 注解暴露一个接口，这样就可以通过 http://localhost:8081/login 访问这个接口了
    @PostMapping("/login")
    //  @RequestParam 是从请求的参数中获取对应的内容
    public Boolean login(@RequestParam String username,
                         @RequestParam String password) {
    //  调用 userService 的方法
    //  按住ctrl键进去看看具体调用的这个函数吧
        return userService.checkPassword(new User(username, password));
    }

    //  在这里仿照上面的 login 方法，分别在 controller层、service层和 mapper层的完善吧，相信你能找到规律！
    @PostMapping("/register")
    public int register(@RequestParam String username,
                         @RequestParam String password) {
        return userService.insertUser(new User(username,password));

    }
}

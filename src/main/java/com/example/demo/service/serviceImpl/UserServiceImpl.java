package com.example.demo.service.serviceImpl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;

@Service
public class UserServiceImpl implements UserService {
    //  自动装配名为 UserMapper 的
    @Resource
    private UserMapper userMapper;

    @Override
    public Boolean checkPassword(User user) {
    //  调用 userMapper 的方法
        String password = userMapper.getPasswordByUsername(user.getUsername());
        if (password == null) {
            return false;
        }
    //  密码校验
        return password.equals(DigestUtils.sha256Hex(user.getPassword()));
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

}

package com.example.demo.service;

import com.example.demo.pojo.User;

public interface UserService {
    Boolean checkPassword(User user);
    int insertUser(User user);
}

package com.ljl.service;


import com.ljl.entity.User;

public interface UserService {
    void regist(User user);

    User login(String username, String password);
}

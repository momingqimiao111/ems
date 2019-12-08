package com.ljl.dao;


import com.ljl.entity.User;

public interface UserDao extends BaseDao<User> {
    User queryByUserName(String username);
}

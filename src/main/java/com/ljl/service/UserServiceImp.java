package com.ljl.service;

import com.ljl.dao.UserDao;
import com.ljl.entity.User;
import com.ljl.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void regist(User user) {
        User user1 = userDao.queryByUserName(user.getUsername());
        if (user1 != null)
            throw new RuntimeException("用户已存在！");
        String salt = MD5Utils.getSalt();
        user.setId(UUID.randomUUID().toString());
        user.setSalt(salt);
        user.setPassword(MD5Utils.getPassword(user.getPassword() + salt));
        userDao.add(user);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public User login(String username, String password) {
        User user = userDao.queryByUserName(username);
        if (user == null)
            throw new RuntimeException("用户不存在");
        String password1 = MD5Utils.getPassword(password + user.getSalt());
        if (!user.getPassword().equals(password1))
            throw new RuntimeException("密码错误！");
        return user;
    }
}

package com.roger.service.impl;

import com.roger.bean.User;
import com.roger.dao.UserDao;
import com.roger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zx on 2017/3/13.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public User getUserById(Long id) {
        return new User(id,"Roger");
    }

}

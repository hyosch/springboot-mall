package com.alston.springbootmall.service.impl;

import com.alston.springbootmall.dao.UserDao;
import com.alston.springbootmall.dto.UserRegisterRequest;
import com.alston.springbootmall.model.User;
import com.alston.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}

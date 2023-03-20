package com.alston.springbootmall.dao;

import com.alston.springbootmall.dto.UserRegisterRequest;
import com.alston.springbootmall.model.User;

public interface UserDao {

    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User getUserByEmail(String email);
}

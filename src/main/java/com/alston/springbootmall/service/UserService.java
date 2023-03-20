package com.alston.springbootmall.service;

import com.alston.springbootmall.dto.UserRegisterRequest;
import com.alston.springbootmall.model.User;

public interface UserService {

    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}

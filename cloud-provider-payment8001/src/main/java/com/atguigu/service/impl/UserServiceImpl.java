package com.atguigu.service.impl;

import com.atguigu.mapper.UserMapper;
import com.atguigu.service.UserService;
import com.atguigu.springcloud.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectUserById(String id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int insertUser(User user) {
        return  userMapper.insertUser(user);
    }
}

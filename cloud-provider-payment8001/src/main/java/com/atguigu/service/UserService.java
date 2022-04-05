package com.atguigu.service;

import com.atguigu.springcloud.bean.User;

public interface UserService {
     User selectUserById(String id);
     int insertUser(User user);
}

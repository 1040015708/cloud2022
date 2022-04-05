package com.atguigu.mapper;

import com.atguigu.springcloud.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
     User selectUserById(String id);

     int insertUser(User user);
}

package com.atguigu.controller;

import com.atguigu.service.UserService;
import com.atguigu.springcloud.bean.Comresult;
import com.atguigu.springcloud.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user1/{id}")
    public User user(@PathVariable("id") String id){
        return userService.selectUserById(id);
    }

    @GetMapping("/user2/{id}")
    public Comresult<User> userComresult(@PathVariable("id") String id){
        User user = userService.selectUserById(id);
        if(user != null){
            return new Comresult<>(200,"查询成功",user);
        }
        return new Comresult<>(444,"查询失败",null);
    }


    @PostMapping("create/user")
    public Comresult<User> createUser( User user){//@RequestBody 一加上这个注解自己的请求就用不了了，但是不加的话restTemplate.postForObject 这个请求就用不了了
        int i = userService.insertUser(user);
        if (i>0){
            return new Comresult<>(200,"插入成功");
        }else {
            return  new Comresult<>(444,"插入失败");
        }
    }

}

package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.bean.User;
import com.atguigu.springcloud.bean.Comresult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController
{

    private final String URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/comsummer/getUser/{id}")
    public Comresult<User> getUser(@PathVariable String id){
        return restTemplate.getForObject(URL+"/user2/"+id,Comresult.class);
    }

    @GetMapping("/comsummer/createUser")
    public Comresult<User> createUser(User user){
        return  restTemplate.postForObject(URL+"create/user",user,Comresult.class);
    }

}

package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.bean.Comresult;
import com.atguigu.springcloud.bean.User;
import com.atguigu.springcloud.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class FeignController {
    @Resource
    private FeignService feignService;

    @GetMapping("/consumer/user2/{id}")
    public Comresult<User> userComresult(@PathVariable("id") String id){
        return feignService.userComresult(id);
    }
}

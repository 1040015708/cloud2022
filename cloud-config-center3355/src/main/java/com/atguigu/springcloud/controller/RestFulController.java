package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class RestFulController {

    @Value("${spring.datasource.password}")
    private String password;

    @GetMapping("/psd")
    public String getPsd(){
        return password;
    }
}

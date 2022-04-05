package com.atguigu.sprincloud.service;

import org.springframework.stereotype.Component;

@Component
public class FabackService implements ConsumerService {
    @Override
    public String handle01(Integer id) {
        return "服务出错啦。。。。。。。";
    }

    @Override
    public String handle02(Integer id) {
        return "服务出错啦。。。。。。。";
    }
}

package com.atguigu.sprincloud.controller;

import com.atguigu.sprincloud.service.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//全局的服务降级处理
//@DefaultProperties(defaultFallback = "handle02HandlerGlobal")
public class ConsumerController {
    @Resource
    private ConsumerService consumerService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String handle01(@PathVariable Integer id){
        return consumerService.handle01(id);
    }


    @GetMapping("/consumer/hystrix/timeOut/{id}")
    //具体方法的服务降级处理
//    @HystrixCommand(fallbackMethod = "handle02Handler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "30000")
//    })
    @HystrixCommand
    public String handle02(@PathVariable Integer id){
        return consumerService.handle02(id);
    }

    public String handle02Handler(@PathVariable Integer id){
        return "我是客户端，调用出错，请稍后再试";
    }

    public String handle02HandlerGlobal(){
        return "我是客户端全局兜底方法，调用出错，请稍后再试";
    }

}

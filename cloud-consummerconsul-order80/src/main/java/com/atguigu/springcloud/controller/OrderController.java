package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController
{

    private final String URL = "http://consul-provider-payment:8006";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/comsummer/consul")
    public String paymentInfo(){
        return  restTemplate.getForObject(URL+"/payment/consul",String.class);
    }

}

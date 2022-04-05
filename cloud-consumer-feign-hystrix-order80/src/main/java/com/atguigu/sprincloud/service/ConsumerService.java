package com.atguigu.sprincloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "hytrix-provider-payment",fallback = FabackService.class)
public interface ConsumerService {

    @GetMapping("/hystrix/ok/{id}")
    public String handle01(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/timeOut/{id}")
    public String handle02(@PathVariable("id") Integer id);
}

package com.atguigu.springcloud.service;

import com.atguigu.springcloud.bean.Comresult;
import com.atguigu.springcloud.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-service")
public interface FeignService {
    @GetMapping("/user2/{id}")
    public Comresult<User> userComresult(@PathVariable("id") String id);
}

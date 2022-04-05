package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
public class HytrixController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/consul")
    public String paymentConsul(){
        return "springcloud with consul:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }

    @GetMapping("/hystrix/ok/{id}")
    public String handle01(@PathVariable Integer id){
        return paymentService.paymentInfo_ok(id);
    }

    @GetMapping("/hystrix/timeOut/{id}")
    public String handle02(@PathVariable Integer id){
        return paymentService.paymentInfo_timeOut(id);
    }

    @GetMapping("/hystrix/fusing/{id}")
    public String handle03(@PathVariable Integer id){
        return paymentService.paymentInfo_fusing(id);
    }


}

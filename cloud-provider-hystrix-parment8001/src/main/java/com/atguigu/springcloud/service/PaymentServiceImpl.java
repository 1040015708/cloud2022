package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "线程池："+Thread.currentThread().getName()+ "paymentInfo_ok,id: "+id;
    }

    @Override
    //服务降级
    @HystrixCommand(fallbackMethod = "paymentInfo_timeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_timeOut(Integer id) {
//        int timeNumber = 1;
//        try{
//            TimeUnit.SECONDS.sleep(timeNumber);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        int a = 2/0;
        return "线程池： "+Thread.currentThread().getName()+"paymentInfo_timeOut,id: "+id;
    }
    //服务 降级和熔断的触发条件：1.请求超时 2.运行时异常 3.宕机
    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentInfo_timeOutHandler1",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value ="true" ),
            @HystrixProperty(name ="circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    @Override
    public String paymentInfo_fusing(Integer id) {
        if(id < 0){
            throw new RuntimeException("id 不能为负数");
        }
        String s = UUID.randomUUID().toString();
        return "id:"+id+"\t"+s;
    }


    public String paymentInfo_timeOutHandler(Integer id){
        return "线程池： "+Thread.currentThread().getName()+"\t"+"繁忙，请稍后再试";
    }

    public String paymentInfo_timeOutHandler1(Integer id){
        return "id为负数："+id+",无法请求";
    }

}

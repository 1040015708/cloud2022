package com.atguigu.springcloud.service;

public interface PaymentService {
     String paymentInfo_ok(Integer id);

     String paymentInfo_timeOut(Integer id);

     String paymentInfo_fusing(Integer id);
}

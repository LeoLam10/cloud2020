package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Leo
 * @version 1.0
 * @date 2021/2/7 2:50
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        System.out.println("调用！");
        return paymentFeignService.getPaymentById(id);
    }

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        return paymentFeignService.create(payment);
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        // openFeign-ribbon 客户端一般默认等待一秒
        return paymentFeignService.paymentFeignTimeout();
    }

}

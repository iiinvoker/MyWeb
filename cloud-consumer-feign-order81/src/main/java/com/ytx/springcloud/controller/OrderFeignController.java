package com.ytx.springcloud.controller;

import com.ytx.springcloud.entities.CommonResult;
import com.ytx.springcloud.entities.Payment;
import com.ytx.springcloud.service.PaymentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/payment/get{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        CommonResult<Payment> payment = paymentService.selectPaymentById(id);
        log.info("查询结果" + payment);
        return payment;
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        //openfeign-ribbon，客户端默认等待1秒
        return paymentService.paymentFeignTimeout();
    }
}

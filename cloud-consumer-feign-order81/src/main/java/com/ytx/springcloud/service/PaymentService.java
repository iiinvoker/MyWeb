package com.ytx.springcloud.service;

import com.ytx.springcloud.entities.CommonResult;
import com.ytx.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE")
public interface PaymentService {

    @GetMapping(value = "/payment/get{id}")
    public CommonResult<Payment> selectPaymentById(@PathVariable("id")Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();

}
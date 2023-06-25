package com.ytx.springcloud.controller;

import com.ytx.springcloud.entities.CommonResult;
import com.ytx.springcloud.entities.Payment;
import com.ytx.springcloud.service.PaymentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverport;

    @Resource
    private PaymentService paymentService;

    @RequestMapping(value = "/payment/zk")
    public String paymentzk(int id) {
        return "springcloud with zookeeper:"+serverport+"\t"+ UUID.randomUUID().toString();
    }
}

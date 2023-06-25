package com.ytx.springcloud.controller;

import com.ytx.springcloud.entities.CommonResult;
import com.ytx.springcloud.entities.Payment;
import com.ytx.springcloud.service.PaymentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverport;

    @PostMapping(value = "/payment/create2")
    public CommonResult create(int id) {

        Payment payment=new Payment((long) id,"诡秘之主");
        System.out.println(payment);
        int result = paymentService.create(payment);
        log.info("插入结果" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,server:"+serverport, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,server:"+serverport, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        System.out.println("???");
        Payment payment = paymentService.selectPaymentById(id);
        log.info("查询结果" + payment);
        if (payment != null) {
            return new CommonResult(200, " 查询数据库成功,server:"+serverport, payment);
        } else {
            return new CommonResult(444, "查询数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverport;
    }
}

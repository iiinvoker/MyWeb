package com.ytx.springcloud.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ytx.springcloud.entities.Payment;
import com.ytx.springcloud.mapper.PaymentMapper;
import com.ytx.springcloud.service.PaymentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {


    @Resource
    private  PaymentMapper paymentMapper;

    public Payment selectPaymentById(Long id) {
        QueryWrapper<Payment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return paymentMapper.selectPaymentById(id);
    }

    @Override
    public int create(Payment payment) {
        return paymentMapper.createPayment(payment);
    }
}

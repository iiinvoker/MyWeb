package com.ytx.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ytx.springcloud.entities.Payment;


public interface PaymentMapper extends BaseMapper<Payment> {
    Payment selectPaymentById(Long id);
    int createPayment(Payment payment);

}
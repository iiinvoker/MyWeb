package com.ytx.springcloud.service;

import com.ytx.springcloud.entities.Payment;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentService {
    public Payment selectPaymentById(Long id);

    public int create(Payment payment);
}

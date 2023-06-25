package com.ytx.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.ytx.springcloud.mapper")
@EnableDiscoveryClient
public class PaymentMain8002 {
    public static  void main(String[] args){
        SpringApplication.run(PaymentMain8002.class,args);
    }
}

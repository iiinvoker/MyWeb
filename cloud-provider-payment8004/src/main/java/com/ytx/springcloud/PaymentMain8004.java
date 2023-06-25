package com.ytx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {
    public static void main(String[] args){
        System.setProperty("zookeeper.sasl.client", "false");
        SpringApplication.run(PaymentMain8004.class,args);
    }
}

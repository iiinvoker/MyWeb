package com.ytx.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ytx.springcloud.mapper")
public class ShiroStudy8005 {
    public static void main(String[] args) {
        SpringApplication.run(ShiroStudy8005.class, args);
    }
}

package com.ytx.springcloud.myloadbanlancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface EasyRule {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}

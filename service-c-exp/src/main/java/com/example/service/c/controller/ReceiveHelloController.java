package com.example.service.c.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class ReceiveHelloController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("spring-cloud-consul-service");
    }

    @GetMapping("/receive")
    public String receive() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("spring-cloud-consul-service");

        log.info("Service IP : {}, Service ID: {}", serviceInstance.getHost(), serviceInstance.getServiceId());
        return new RestTemplate().getForEntity(serviceInstance.getUri().toString() + "/hello", String.class).getBody();
    }
}

package com.zhaluo.box.controller;

import feign.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Registration registration;

    @GetMapping("/helllo")
    public String index() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();

        String serviceId = registration.getServiceId();
        System.out.println(serviceId);

        System.out.println("/hello; host:" + instance.getHost()+"-------"+instance.getServiceId());
        return "hello";
    }
}

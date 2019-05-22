package com.zhaluo.box;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class Zuul_9007_StartSpringCloudApp {

    public static void main(String[] args) {
       
        SpringApplication.run(Zuul_9007_StartSpringCloudApp.class, args);
    }

}

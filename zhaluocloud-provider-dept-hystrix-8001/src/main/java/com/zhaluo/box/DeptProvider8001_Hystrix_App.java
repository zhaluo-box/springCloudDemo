package com.zhaluo.box;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient //本服务启动后会自动注册进eureka服务中,充当客户端,作为一个提供者
@EnableCircuitBreaker//对hystrixR熔断机制的支持
public class DeptProvider8001_Hystrix_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_Hystrix_App.class, args);
    }

}

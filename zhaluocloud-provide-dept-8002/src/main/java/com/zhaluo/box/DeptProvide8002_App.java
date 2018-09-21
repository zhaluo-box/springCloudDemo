package com.zhaluo.box;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中,充当客户端
public class DeptProvide8002_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvide8002_App.class, args);
    }

}

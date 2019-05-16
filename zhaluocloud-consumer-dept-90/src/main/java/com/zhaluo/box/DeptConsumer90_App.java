package com.zhaluo.box;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaClient
public class DeptConsumer90_App {

    @Bean
    public RestTemplate restTemplate(){
      return   new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer90_App.class, args);
    }
    
}
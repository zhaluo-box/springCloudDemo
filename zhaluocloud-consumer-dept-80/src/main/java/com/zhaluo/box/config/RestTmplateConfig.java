package com.zhaluo.box.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTmplateConfig {

    @Bean
    @LoadBalanced //负载均衡
    public RestTemplate geRestTemplate() {
        return new RestTemplate();
    }
    
}

package com.zhaluo.box.controller;

import com.zhaluo.box.api.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

//    private static final  String  REST_URL_PREFIX = "http://localhost:8004";

    //结合ribbon 自动咨询服务列表 这里可以采用el表达式注入进来
    private static final String REST_URL_PREFIX = "http://ZHALUOCLOUD-DEPT";  //服务名 -->spring.application.name
    
    @Autowired
    private RestTemplate restTemplate;
    
    /**
     * 
     * Description:[添加dept]
     * @param dept
     * @return
     */
    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept)
    {
         return restTemplate
                 .postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    @GetMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id) {
    
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }
    
    @GetMapping(value = "/consumer/dept/list")
    public List<?> list() {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }

    @GetMapping("/consumer/dept/getClient")
    public List<?> getClient(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/client",List.class);
    }

}

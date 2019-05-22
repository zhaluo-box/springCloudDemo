package com.zhaluo.box.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhaluo.box.api.entity.Dept;
import com.zhaluo.box.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService service;

    @Autowired
    private DiscoveryClient client;

    @PostMapping(value = "/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @GetMapping(value = "/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "processHystrixGet")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = this.service.get(id);
        if (null == dept) {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrixGet(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id)
                .setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }


    @GetMapping(value = "/dept/list")
    public List<Dept> list() {
        return service.list();
    }

    @GetMapping("/dept/client")
    public List<?> getClient() {
        List<String> services = client.getServices();
        //        List<ServiceInstance> instances = client.getInstances(services.get(0));
        List<List<ServiceInstance>> list = new ArrayList<>();
        services.forEach(t ->
                list.add(client.getInstances(t))
        );
        return list;
    }

}

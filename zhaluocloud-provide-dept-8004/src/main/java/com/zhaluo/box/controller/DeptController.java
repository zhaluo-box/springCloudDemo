package com.zhaluo.box.controller;


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
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
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

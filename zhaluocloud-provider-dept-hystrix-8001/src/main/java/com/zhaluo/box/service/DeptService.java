package com.zhaluo.box.service;

import com.zhaluo.box.api.entity.Dept;

import java.util.List;


public interface DeptService {

    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();

}

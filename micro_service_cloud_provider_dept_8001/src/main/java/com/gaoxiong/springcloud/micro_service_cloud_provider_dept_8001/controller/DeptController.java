package com.gaoxiong.springcloud.micro_service_cloud_provider_dept_8001.controller;

import com.gaoxiong.springcloud.entities.Dept;
import com.gaoxiong.springcloud.micro_service_cloud_provider_dept_8001.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gaoxiong
 * @ClassName DeptController
 * @Description TODO
 * @date 2018/9/3 0:22
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @PostMapping(value = "/dept/add")
    public boolean addDept(@RequestBody Dept dept ) {
        return deptService.addDept(dept);
    }

    @GetMapping(value = "/dept/{id}")
    public Dept get( @PathVariable("id") Long id ) {
        return deptService.findById(id);
    }

    @GetMapping(value = "/dept")
    public List<Dept> list() {
        return deptService.findAll();
    }
}

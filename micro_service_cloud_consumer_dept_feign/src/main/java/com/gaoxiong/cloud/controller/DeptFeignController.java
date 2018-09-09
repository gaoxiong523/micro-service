package com.gaoxiong.cloud.controller;

import com.gaoxiong.springcloud.entities.Dept;
import com.gaoxiong.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gaoxiong
 * @ClassName DeptFeignController
 * @Description TODO
 * @date 2018/9/9 13:46
 */
@RestController("/feignConsumer")
public class DeptFeignController {
    @Autowired
    private DeptClientService deptClientService;

    @PostMapping(value = "/dept/add")
    public boolean addDept(@RequestBody Dept dept ) {
        return deptClientService.addDept(dept);
    }

    @GetMapping(value = "/dept/{id}")
    public Dept get( @PathVariable("id") Long id ) {
        return deptClientService.get(id);
    }

    @GetMapping(value = "/dept")
    public List<Dept> list() {
        return deptClientService.list();
    }
}

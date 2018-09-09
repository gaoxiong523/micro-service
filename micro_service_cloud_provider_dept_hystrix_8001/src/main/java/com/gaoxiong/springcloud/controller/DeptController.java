package com.gaoxiong.springcloud.controller;

import com.gaoxiong.springcloud.entities.Dept;
import com.gaoxiong.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
//    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get( @PathVariable("id") Long id ) {
        Dept dept = deptService.findById(id);
        if (dept ==null) {
            throw  new RuntimeException("该 ID :"+id + "没有对应的信息");
        }
        return dept;
    }

    @GetMapping(value = "/dept")
    public List<Dept> list() {
        return deptService.findAll();
    }

    public Dept processHystrix_Get(@PathVariable(value = "id") Long id) {
        return new Dept().setDeptno(id).setDname("该ID"+id+"没有对应的信息,null --@HystrixCommond")
                .setDb_source("no this datasource in mysql");
    }


    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/discovery" ,method = RequestMethod.GET)
    public Object discover() {
        List<String> services = discoveryClient.getServices();
        System.out.println("发现了这么多服务"+services);

        List<ServiceInstance> instances = discoveryClient.getInstances("dept-8001-provider");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId());
            System.out.println(instance.getHost());
            System.out.println(instance.getPort());
            System.out.println(instance.getUri());
        }
        return this.discoveryClient;
    }
}

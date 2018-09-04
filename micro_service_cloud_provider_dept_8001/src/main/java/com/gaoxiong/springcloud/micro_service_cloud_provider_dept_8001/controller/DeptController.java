package com.gaoxiong.springcloud.micro_service_cloud_provider_dept_8001.controller;

import com.gaoxiong.springcloud.entities.Dept;
import com.gaoxiong.springcloud.micro_service_cloud_provider_dept_8001.service.DeptService;
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
    public Dept get( @PathVariable("id") Long id ) {
        return deptService.findById(id);
    }

    @GetMapping(value = "/dept")
    public List<Dept> list() {
        return deptService.findAll();
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

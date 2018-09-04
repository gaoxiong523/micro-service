package com.gaoxiong.springcloud.controller;

import com.gaoxiong.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author gaoxiong
 * @ClassName DeptController_Consumer
 * @Description TODO
 * @date 2018/9/3 13:44
 */
@RestController
public class DeptController_Consumer {
    /**
     * 使用restTemplate 简单调用接口
     */
    private static final String REST_URL_PREFIX = "http://microservicecloud-dept/";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/dept")
    public List<Dept> list() {
        List list = restTemplate.getForObject(REST_URL_PREFIX + "/dept", List.class);
        return list;
    }

    @PostMapping(value = "/consumer/dept/add")
    public boolean addDept(Dept dept) {
        Boolean aBoolean = restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
        return aBoolean;
    }

    @GetMapping(value = "/consumer/dept/{id}")
    public Dept getById( @PathVariable Long id ) {
        Dept forObject = restTemplate.getForObject(REST_URL_PREFIX + "/dept/" + id, Dept.class);
        return forObject;
    }

}

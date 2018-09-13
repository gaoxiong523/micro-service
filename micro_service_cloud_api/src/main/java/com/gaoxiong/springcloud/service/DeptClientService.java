package com.gaoxiong.springcloud.service;

import com.gaoxiong.fallback.DeptClientServiceFallbackFactory;
import com.gaoxiong.springcloud.entities.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author gaoxiong
 * @ClassName DeptClientService
 * @Description TODO
 * @date 2018/9/9 13:40
 */
@FeignClient(value = "microservicecloud-dept",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @PostMapping(value = "/dept/add")
    public boolean addDept(@RequestBody Dept dept );

    @GetMapping(value = "/dept/{id}")
    public Dept get( @PathVariable("id") Long id );

    @GetMapping(value = "/dept")
    public List<Dept> list() ;
}

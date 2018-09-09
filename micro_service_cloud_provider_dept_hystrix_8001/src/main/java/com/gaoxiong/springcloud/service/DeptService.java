package com.gaoxiong.springcloud.service;

import com.gaoxiong.springcloud.entities.Dept;

import java.util.List;

/**
 * @author gaoxiong
 * @ClassName DeptService
 * @Description TODO
 * @date 2018/9/3 0:19
 */
public interface DeptService {
    boolean addDept ( Dept dept );

    Dept findById ( Long id );

    List<Dept> findAll ();
}

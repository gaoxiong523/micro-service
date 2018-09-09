package com.gaoxiong.springcloud.service;


import com.gaoxiong.springcloud.dao.DeptDao;
import com.gaoxiong.springcloud.entities.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaoxiong
 * @ClassName DeptServiceImpl
 * @Description TODO
 * @date 2018/9/3 0:19
 */
@Service
@Slf4j
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    public boolean addDept ( Dept dept ) {
        return deptDao.addDept(dept);
    }

    public Dept findById ( Long id ) {
        return deptDao.findById(id);
    }

    public List<Dept> findAll () {
        return deptDao.findAll();
    }
}

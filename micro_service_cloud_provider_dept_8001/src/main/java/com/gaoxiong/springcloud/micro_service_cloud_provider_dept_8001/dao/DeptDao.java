package com.gaoxiong.springcloud.micro_service_cloud_provider_dept_8001.dao;

import com.gaoxiong.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * @author gaoxiong
 * @ClassName DeptDao
 * @Description TODO
 * @date 2018/9/3 0:08
 */
@Mapper
public interface DeptDao {

    @Insert("INSERT INTO dept(dname,db_source) VALUES(#{dname},DATABASE())")
    boolean addDept( Dept dept );

    @Select("select deptno,dname,db_source from dept where deptno=#{deptno}")
    Dept findById(Long id);

    @Select("select deptno,dname,db_source from dept")
    List<Dept> findAll();
}

package com.gaoxiong.fallback;

import com.gaoxiong.springcloud.entities.Dept;
import com.gaoxiong.springcloud.service.DeptClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author gaoxiong
 * @ClassName DeptClientServiceFallbackFactory
 * @Description TODO
 * @date 2018/9/9 22:07
 */
@Component // 这个注解不能忘记添加!!!
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    public DeptClientService create ( Throwable throwable ) {
        return new DeptClientService() {
            public boolean addDept ( Dept dept ) {
                return false;
            }

            public Dept get ( Long id ) {
                return new Dept().setDeptno(id).setDname("该ID"+id+"没有对应的信息,null --服务已停用")
                        .setDb_source("no this datasource in mysql");
            }

            public List<Dept> list () {
                return null;
            }
        };
    }
}

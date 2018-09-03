package com.gaoxiong.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author gaoxiong
 * @ClassName Dept
 * @Description TODO
 * @date 2018/9/2 23:16
 */
@Data
@AllArgsConstructor //全参构造
@NoArgsConstructor  //无参构造
@Accessors(chain = true )  //链式调用
public class Dept implements Serializable {

    private Long deptno;
    private String dname;
    private String db_source;
}

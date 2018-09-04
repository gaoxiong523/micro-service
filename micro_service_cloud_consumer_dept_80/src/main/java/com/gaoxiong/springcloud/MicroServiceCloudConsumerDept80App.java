package com.gaoxiong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author gaoxiong
 * @ClassName MicroServiceCloudConsumerDept80App
 * @Description TODO
 * @date 2018/9/3 14:00
 */
@SpringBootApplication
@EnableEurekaClient
public class MicroServiceCloudConsumerDept80App {
    public static void main ( String[] args ) {
        SpringApplication.run(MicroServiceCloudConsumerDept80App.class,args);
    }
}

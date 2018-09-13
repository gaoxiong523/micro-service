package com.gaoxiong.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {
        "com.gaoxiong.springcloud"
})
@ComponentScan(basePackages = {"com.gaoxiong"})
public class MicroServiceCloudConsumerDeptFeignApplication {

    public static void main ( String[] args ) {
        SpringApplication.run(MicroServiceCloudConsumerDeptFeignApplication.class, args);
    }
}

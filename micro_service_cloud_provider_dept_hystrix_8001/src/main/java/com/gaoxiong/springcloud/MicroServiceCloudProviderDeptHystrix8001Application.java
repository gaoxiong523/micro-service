package com.gaoxiong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
public class MicroServiceCloudProviderDeptHystrix8001Application {

    public static void main ( String[] args ) {
        SpringApplication.run(MicroServiceCloudProviderDeptHystrix8001Application.class, args);
    }
}

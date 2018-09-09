package com.gaoxiong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
public class MicroServiceCloudProviderDeptHystrix8001Application {

    public static void main ( String[] args ) {
        SpringApplication.run(MicroServiceCloudProviderDeptHystrix8001Application.class, args);
    }
}

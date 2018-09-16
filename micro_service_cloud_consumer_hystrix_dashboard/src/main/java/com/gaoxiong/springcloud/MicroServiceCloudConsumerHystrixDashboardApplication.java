package com.gaoxiong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class MicroServiceCloudConsumerHystrixDashboardApplication {

    public static void main ( String[] args ) {
        SpringApplication.run(MicroServiceCloudConsumerHystrixDashboardApplication.class, args);
    }
}

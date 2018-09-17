package com.gaoxiong.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroServiceCloudConfig3344Application {

    public static void main ( String[] args ) {
        SpringApplication.run(MicroServiceCloudConfig3344Application.class, args);
    }
}

package com.gaoxiong.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoxiong
 * @ClassName ConfigClientRest
 * @Description TODO
 * @date 2018/9/17 23:12
 */
@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getConfig")
    public String getConfig () {
        return "applicationName: "+applicationName +"eurekaServers: "+eurekaServers+"serverPort: "+serverPort;
    }
}

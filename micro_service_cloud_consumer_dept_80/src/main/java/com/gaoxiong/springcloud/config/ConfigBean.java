package com.gaoxiong.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author gaoxiong
 * @ClassName ConfigBean
 * @Description TODO
 * @date 2018/9/3 13:40
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //spring cloud ribbon 是基于neflix ribbon 实现的一套客户端负载均衡工具
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

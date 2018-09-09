package com.gaoxiong.springcloud.config;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    /**
     * 负载均衡的轮询规则切换为 随机
     * @return
     */
//    @Bean
    public IRule myRule () {
        return new RandomRule();
    }


}

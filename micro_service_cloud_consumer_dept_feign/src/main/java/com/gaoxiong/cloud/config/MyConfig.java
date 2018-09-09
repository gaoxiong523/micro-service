package com.gaoxiong.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaoxiong
 * @ClassName MyConfig
 * @Description TODO
 * @date 2018/9/9 14:32
 */
@Configuration
public class MyConfig {

    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}

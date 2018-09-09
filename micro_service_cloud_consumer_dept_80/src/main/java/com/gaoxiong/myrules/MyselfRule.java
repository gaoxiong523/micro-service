package com.gaoxiong.myrules;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaoxiong
 * @ClassName MyselfRule
 * @Description TODO
 * @date 2018/9/8 23:43
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule() {
//        return new RoundRobinRule();
        return new RoundRobinRule_GX(); //使用我们自己定义的rule
    }
}

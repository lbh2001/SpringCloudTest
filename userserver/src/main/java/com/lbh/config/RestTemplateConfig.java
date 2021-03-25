package com.lbh.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author lbh
 * @Date 2021/3/25
 * @Description:
 */

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced   //实现负载均衡的RestTemplate
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

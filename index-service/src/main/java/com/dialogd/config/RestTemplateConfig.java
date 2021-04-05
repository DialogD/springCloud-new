package com.dialogd.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: DJA
 * @Date: 2019/11/30
 */
@Component
public class RestTemplateConfig {

    @Bean
    @LoadBalanced  //默认为轮询机制
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

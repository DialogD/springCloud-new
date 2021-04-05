package com.dialogd.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author: DJA
 * @Date: 2019/12/3
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ApiZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiZuulApplication.class,args);
    }
}

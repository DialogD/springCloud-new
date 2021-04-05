package com.dialogd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: DJA
 * @Date: 2019/11/30
 */
@SpringBootApplication
@EnableEurekaClient   //声明eurekaClient客户端
@EnableFeignClients  //声明式rest调用的功能
@EnableCircuitBreaker   //开启熔断
@EnableHystrixDashboard   //开启仪表盘
public class IndexServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(IndexServiceApplication.class,args);
    }
}

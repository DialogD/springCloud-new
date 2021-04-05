package com.dialogd.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: DJA
 * @Date: 2019/12/3
 */
@RestController
@RequestMapping("client")
@RefreshScope
public class ClientController {

    @Value("${configImage.server}")
    private String configImageServer;

    @RequestMapping("get")
    public String getConfigImageServer(){
        return configImageServer;
    }
}

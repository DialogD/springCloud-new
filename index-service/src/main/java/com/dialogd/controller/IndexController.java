package com.dialogd.controller;

import com.dialogd.entity.Product;
import com.dialogd.feign.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: DJA
 * @Date: 2019/11/30
 */
@Controller
@RequestMapping("index")
public class IndexController {

    private String product_server_url = "http://PRODUCT-SERVICE/product/list";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IProductService productService;

    @RequestMapping("show")
    @ResponseBody
    public List<Product> show(Model model){
        //首页需要显示商品信息，则就需要调用商品服务
        //以http方式调用接口:http://localhost:8080/product/list
        //httpClient
        //spring RestTemplate 直接调用接口
        //RestTemplate restTemplate = new RestTemplate();

        //注册中心--实现解耦
        //String list = restTemplate.getForObject(product_server_url, String.class);
        //list json-->List<Product>

        List<Product> list = productService.list();
        return list;
    }
}

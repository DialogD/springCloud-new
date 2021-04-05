package com.dialogd.feign;

import com.dialogd.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DJA
 * @Date: 2019/11/30
 */
@FeignClient(name = "PRODUCT-SERVICE",fallback = IProductService.productServiceCallback.class)
public interface IProductService {

    @GetMapping("product/list")
    public List<Product> list();


    //添加兜底方案
    @Component
    @Slf4j
    static class productServiceCallback implements IProductService{

        @Override
        public List<Product> list() {
            log.info("调用product-service，进入熔断处理方案");
            List<Product> list = new ArrayList<>();
            return list;
        }
    }
}

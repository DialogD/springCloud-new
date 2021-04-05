package com.dialogd.service.impl;

import com.dialogd.entity.Product;
import com.dialogd.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DJA
 * @Date: 2019/11/30
 */
@Service
public class productServiceImpl implements IProductService {

    @Override
    public List<Product> list() {
        //构建虚拟数据(正常到数据库中查询)
        List<Product> list = new ArrayList<>();
        list.add(new Product(1L,"3天精通java",9999L));
        list.add(new Product(2L,"日赚十万",888L));
        return list;
    }
}

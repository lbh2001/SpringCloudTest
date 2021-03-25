package com.lbh.controller;

import com.lbh.client.ProductClient;
import com.lbh.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author lbh
 * @Date 2021/3/25
 * @Description:
 */
@RestController
public class FeignController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/feign/test")
    public Map<String,Object> findAll(){
        return productClient.findAll();
    }

    @GetMapping("/feign/findOne")
    public Map<String,Object> findOne(String productId){
        return productClient.findOne(productId);
    }

    @PostMapping("/feign/update")
    @ResponseBody
    public Map<String,Object> update(Product product){
        return productClient.update(product);
    }

}

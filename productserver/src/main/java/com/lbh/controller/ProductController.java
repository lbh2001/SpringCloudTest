package com.lbh.controller;

import com.lbh.entity.Product;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lbh
 * @Date 2021/3/25
 * @Description:
 */

@Slf4j
@RestController
public class ProductController {

    @PostMapping("/product/update")
    @ResponseBody
    public Map<String,Object> update(Product product){
        Map<String,Object> map = new HashMap<>();
        map.put("status","success");
        map.put("msg",product.toString());
        return map;
    }


    @GetMapping("/product/show")
    public String showProductMessage(){
        log.info("product server: here is product show~");
        return "product server: here is product show~";
    }

    @GetMapping("/product/findAll")
    public Map<String,Object> findAll(){
        Map<String,Object> map = new HashMap<>();
        map.put("status","success");
        map.put("msg","all product");
        return map;
    }

    @GetMapping("/product/findOne")
    public Map<String,Object> findOne(String productId){
        Map<String,Object> map = new HashMap<>();
        map.put("status","success");
        map.put("msg",productId);
        return map;
    }

}

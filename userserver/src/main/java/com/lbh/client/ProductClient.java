package com.lbh.client;

import com.lbh.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author lbh
 * @Date 2021/3/25
 * @Description:
 */

//调用 product服务的 open feign组件
@FeignClient(value = "productserver")   //调用的服务名
public interface ProductClient {

    @GetMapping("/product/findAll") //对应商品服务中controller相应方法的路径
    Map<String,Object> findAll();

    @GetMapping("/product/findOne")
    Map<String,Object> findOne(@RequestParam("productId") String productId);

    @PostMapping("/product/update")
    @ResponseBody
    Map<String,Object> update(Product product);

}

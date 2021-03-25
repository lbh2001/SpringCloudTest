package com.lbh.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lbh
 * @Date 2021/3/25
 * @Description:
 */

@RestController
@Slf4j
public class UserController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/user/show")
    public String showProductMessage(){
        RestTemplate restTemplate = new RestTemplate();
        String msg = restTemplate.getForObject("http://localhost:9998/product/show", String.class);
        log.info(msg);
        return "UserController:" + msg;
    }

    @GetMapping("/user/findAll")
    public String findAll(){
//        ServiceInstance serviceInstance = loadBalancerClient.choose("productserver");
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/findAll";
//        String msg = restTemplate.getForObject(url, String.class);
//        return msg+"port:"+serviceInstance.getPort();

        String forObject = restTemplate.getForObject("http://productserver/product/findAll", String.class);
        return forObject;

    }

}

package com.example.eurekaconsumer.controller;

import com.example.eurekaconsumer.feign.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

//    @GetMapping("/consumer")
//    public String dc() {
//        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
//        System.out.println(url);
//        return restTemplate.getForObject(url, String.class);
//    }

    @Autowired
    DcClient dcClient;

    @GetMapping("/consumer")
    public String dcByFeign(@RequestParam int id) {
        String result = dcClient.consumer(id);
        System.out.println("feign do ok" + result);
        return result;

    }

}

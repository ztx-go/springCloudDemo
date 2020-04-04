package com.example.eurekaclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    @HystrixCommand(fallbackMethod = "hystrixFallBackMethod")
    public String dc(@RequestParam int id) {
        if (1 == id) {
            throw new RuntimeException("手动制造异常");
        }
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    public String hystrixFallBackMethod(int id) {
        return "method error";
    }

}
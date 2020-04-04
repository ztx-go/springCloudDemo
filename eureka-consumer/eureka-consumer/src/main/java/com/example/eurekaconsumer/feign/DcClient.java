package com.example.eurekaconsumer.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-client")
public interface DcClient {

    @GetMapping("/dc")
    String consumer(@RequestParam("id") int id);

}

//引入feign的依赖，然后启动类开启，然后定义调用接口，就可以在其他地方使用这个外部接口提供的服务
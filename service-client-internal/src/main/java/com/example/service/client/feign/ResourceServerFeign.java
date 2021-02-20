package com.example.service.client.feign;

import com.example.service.client.config.CustomFeignSecurityConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "RESOURCE-SERVER", configuration = CustomFeignSecurityConfig.class)
public interface ResourceServerFeign {

    @RequestMapping(value="/hello", method = RequestMethod.POST)
    String getHello(@RequestBody String name);
}

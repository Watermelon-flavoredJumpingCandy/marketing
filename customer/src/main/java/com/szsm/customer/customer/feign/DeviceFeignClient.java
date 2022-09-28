package com.szsm.customer.customer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "device-service")
public interface DeviceFeignClient {
    @RequestMapping("/deviceInfoController/test")
    public String test();
}

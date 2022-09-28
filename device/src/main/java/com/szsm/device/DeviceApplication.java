package com.szsm.device;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.szsm.device.mapper")
public class DeviceApplication {

    public static void main(String[] args) {

        SpringApplication.run(DeviceApplication.class, args);
    }

}

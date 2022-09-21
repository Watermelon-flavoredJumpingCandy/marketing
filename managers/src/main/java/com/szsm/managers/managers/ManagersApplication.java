package com.szsm.managers.managers;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.szsm.managers.managers.mapper")
public class ManagersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagersApplication.class, args);


    }
}





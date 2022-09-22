package com.szsm.customer.customer;

import com.szsm.customer.customer.config.ShardeJedisPoolConfig;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@EnableConfigurationProperties({ShardeJedisPoolConfig.class})
@SpringBootApplication
@MapperScan("com.szsm.customer.customer.mapper")
public class CustomerApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerApplication.class, args);
    }

}

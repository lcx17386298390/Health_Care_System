package com.acm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.acm.mapper")
public class adminApplication {
    public static void main(String[] args) {
        SpringApplication.run(adminApplication.class,args);
    }
}

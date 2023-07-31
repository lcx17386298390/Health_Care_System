package com.acm;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.acm.mapper")
public class patientApplication {
    public static void main(String[] args) {
        SpringApplication.run(patientApplication.class, args);
    }
}

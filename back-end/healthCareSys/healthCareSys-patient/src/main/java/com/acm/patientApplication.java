package com.acm;


import lombok.extern.slf4j.Slf4j;
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

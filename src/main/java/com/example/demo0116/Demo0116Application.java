package com.example.demo0116;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.example.demo0116.dao")
@EnableTransactionManagement
@EnableScheduling
public class Demo0116Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo0116Application.class, args);
    }

}

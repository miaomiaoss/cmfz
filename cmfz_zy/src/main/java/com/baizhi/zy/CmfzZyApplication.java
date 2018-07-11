package com.baizhi.zy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baizhi.zy.dao")
public class CmfzZyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmfzZyApplication.class, args);
    }
}

package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.dao")
public class SpringbootApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringbootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}

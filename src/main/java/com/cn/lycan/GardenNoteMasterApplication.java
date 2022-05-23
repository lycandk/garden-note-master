package com.cn.lycan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class GardenNoteMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GardenNoteMasterApplication.class, args);
    }

}

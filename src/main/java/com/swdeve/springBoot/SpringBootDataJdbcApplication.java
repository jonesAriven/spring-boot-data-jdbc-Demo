package com.swdeve.springBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value="com.swdeve.springBoot.mapper")//添加了该注解，则com.swdeve.mapper包下的类无需添加@mapper注解也可识别为mapper
@SpringBootApplication
public class SpringBootDataJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataJdbcApplication.class, args);
    }

}


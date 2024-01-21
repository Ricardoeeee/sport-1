package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.Dao")
public class SpringbootSportApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSportApplication.class, args);
    }

}

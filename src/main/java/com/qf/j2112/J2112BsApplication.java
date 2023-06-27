package com.qf.j2112;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.qf.j2112.mapper"})
public class J2112BsApplication {

    public static void main(String[] args) {
        SpringApplication.run(J2112BsApplication.class, args);
    }

}
